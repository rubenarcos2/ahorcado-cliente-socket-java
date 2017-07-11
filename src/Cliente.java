
import Utilidades.DatosConexion;
import Utilidades.DatosPartida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * CLIENTE de comunicaciones -------------------------
 *
 * @author Rubén
 */
public class Cliente {

    private static boolean conectado, solicitadoCierre;
    private static DatosConexion datosConexion;
    private static Socket usuario;
    private static DataInputStream flujoEntrada;
    private static DataOutputStream flujoSalida;
    private static ObjectOutputStream flujoSalidaObjeto;
    private static ObjectInputStream flujoEntradaObjeto;
    private static JButton[] listaBotones;
    private static JTextArea txtMensajesRecibidos;
    private static JTextField txtMensajeEnviado;
    private static JTextField txtLetrasEnviadas;
    private static JTextField txtLetrasFallidas;
    private static JLabel lblPalabra;
    private static JLabel lblTurnoActual;
    private static JLabel lblFallos;
    private static JLabel lblImgAhorcado;
    private static JLabel lblAciertos;
    private static JList listaUsuarios;
    private static Ventana ventana;
    private static ArrayList<JButton> listaBtnTeclado;

    private static final String DESCONEXION = "[DESCONECTAR]";

    private static DatosPartida datosPartida;
    private static int aciertosUsuario, fallosUsuario;
    private static String nombreUsuario;
    private static boolean haGanado;
    
    public static void main(String[] args) {
        fallosUsuario = 0;
        aciertosUsuario = 0;
        nombreUsuario = "";
        usuario = null;
        haGanado = false;
        conectado = false;
        solicitadoCierre = false;
        ventana = new Ventana();
        txtMensajesRecibidos = ventana.getTxtAreaMensajesRecibidos();
        txtMensajeEnviado = ventana.getTxtMensajesEnviados();
        txtLetrasEnviadas = ventana.getTxtEnviarLetra();
        txtLetrasFallidas = ventana.getTxtLetrasFallidas();
        listaUsuarios = ventana.getListaUsuarios();
        listaBotones = ventana.getListaBotones();
        lblPalabra = ventana.getLblPalabra();
        lblFallos = ventana.getLblFallos();
        lblImgAhorcado = ventana.getLblImgAhorcado();
        lblTurnoActual = ventana.getLblTurnoUsuario();
        lblAciertos = ventana.getLblAciertos();
        listaBtnTeclado = ventana.getListaBtnTeclado();

        /**
         * ******************************************************
         * ASIGNACIÓN DE LOS EVENTOS DE LOS BOTONES DE LA VENTANA
         * *******************************************************
         */
        //Botón enviar mensaje
        listaBotones[0].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            enviarMensaje(txtMensajeEnviado.getText());
                            txtMensajeEnviado.setText("");
                        } catch (IOException ex) {
                            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR en la recepción de los datos de la ventana " + ex);
                        }
                    }
                }
        );

        //Botón de desconexión, salir y retirarse
        listaBotones[1].addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            desconectar();
                        } catch (IOException ex) {
                            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR al realizar la desconexión: " + ex);
                        }
                    }
                }
        );

        //Botón de consultar letra y control de solicitud de letra ya consultada.
        listaBotones[3].addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            if (!txtLetrasEnviadas.getText().isEmpty()) {
                                if (datosPartida.getLetrasFalladas().contains(txtLetrasEnviadas.getText()) || lblPalabra.getText().contains(txtLetrasEnviadas.getText())) {
                                    JOptionPane.showMessageDialog(ventana, "La letra indicada ya se ha consultado", "Letra fallida repetida", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    datosPartida.setConsultaLetra(txtLetrasEnviadas.getText());
                                    enviarMensaje("Consulta la letra: " + txtLetrasEnviadas.getText());
                                    enviarDatosPartida();
                                    txtLetrasEnviadas.setText("");
                                }
                            }
                        } catch (IOException ex) {
                            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR en la consulta de letra: " + ex);
                        }
                    }
                }
        );

        //Botón de adivinación de la palabra completa.
        listaBotones[4].addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            String respuesta = JOptionPane.showInputDialog(ventana, "Introduzca la palabra que cree que es: ");
                            if (respuesta.length() > 1 && !respuesta.isEmpty() && respuesta != null) {
                                datosPartida.setConsultaLetra(respuesta);
                                enviarDatosPartida();
                            }
                        } catch (IOException ex) {
                            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR en el envío de los datos de la partida, al adivinar la palabra: " + ex);
                        }
                    }
                }
        );

        //Inicio de la conexión del cliente, arranque inicial.
        try {
            solicitarDatosConexion();
            solicitarNombre();
            System.out.println(Utilidades.Utils.getHoraActual() + "PROGRAMA CLIENTE INICIADO...");
            conectar();
            ventana.setConectado();
            gestionarMensajes();
        } catch (IOException e) {
            ventana.setDesconectado();
            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR en la comunicación con el servidor: " + e);
            if (!solicitadoCierre) {
                JOptionPane.showMessageDialog(null, "El servidor no está disponible", "Conexión rechazada", JOptionPane.ERROR_MESSAGE);
            }
            //Cierro la ventana.
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR general: " + ex);
        }
    }

    //Mensajes iniciales con la configuración de conexión, también gestiona la lectura de la configuración,
    //almacenada en el fichero datosConexión.txt
    private static void solicitarDatosConexion() throws IOException, Exception {
        datosConexion = new DatosConexion();
        String[] valoresConexion = Utilidades.LeerDatosConexionFichero.getListaPalabras();
        for (int i = 0; i < valoresConexion.length; i++) {
            if (valoresConexion[i].contains("HOST")) {
                datosConexion.setHost(valoresConexion[i].substring(5));
            } else if (valoresConexion[i].contains("PUERTO")) {
                datosConexion.setPuerto(Integer.valueOf(valoresConexion[i].substring(7)));
            } else if (valoresConexion[i].contains("NOMBRE")) {
                if (!valoresConexion[i].substring(7).isEmpty()) {
                    datosConexion.setNombreUsuario(valoresConexion[i].substring(7));
                }
            }
        }
        try {
            String host = JOptionPane.showInputDialog("Introduzca la IP del servidor:", datosConexion.getHost());
            if (host == null) {
                System.exit(0);
            }
            datosConexion.setHost(host);
            String puerto = JOptionPane.showInputDialog("Introduzca el puerto del servidor:", datosConexion.getPuerto());
            if (puerto == null) {
                System.exit(0);
            }
            datosConexion.setPuerto(Integer.valueOf(puerto));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos: " + ex, "Datos de conexión", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void solicitarNombre() {
        try {
            String respuesta;
            do {
                respuesta = JOptionPane.showInputDialog("Introduzca su nombre de usuario: ", datosConexion.getNombreUsuario());
                if (respuesta == null) {
                    System.exit(0);
                } else {
                    nombreUsuario = respuesta;
                    ventana.setTitle("Cliente de ahorcado - " + nombreUsuario);
                }
            } while (respuesta.isEmpty());
            datosConexion.setNombreUsuario(respuesta);
            ventana.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos: " + ex, "Datos de conexión", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void conectar() throws IOException {
        usuario = new Socket(datosConexion.getHost(), datosConexion.getPuerto());
        if (usuario.isConnected()) {
            flujoSalida = new DataOutputStream(usuario.getOutputStream());
            flujoEntrada = new DataInputStream(usuario.getInputStream());
            flujoSalidaObjeto = new ObjectOutputStream(usuario.getOutputStream());
            flujoEntradaObjeto = new ObjectInputStream(usuario.getInputStream());
            //Envío aviso de conexión con el nombre de usuario
            enviarMensaje("[NOMBRE]" + datosConexion.getNombreUsuario());
            conectado = true;
            setActivarDesactivarControles(false);
        } else {
            ventana.setDesconectado();
            System.out.println(Utilidades.Utils.getHoraActual() + "El servidor no está disponible");
            JOptionPane.showMessageDialog(null, "El servidor no está disponible", "Conexión rechazada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void gestionarMensajes() throws IOException {
        while (conectado) {
            String mensaje = recibirMensaje();
            try {
                if (mensaje.contains(DESCONEXION)) {
                    desconectar();
                } else if (mensaje.contains("[OBJETO]")) {
                    recibirObjeto();
                } else if (mensaje.contains("[INICIAR PARTIDA]")) {
                    setActivarDesactivarControles(true);
                    fallosUsuario = 0;
                    aciertosUsuario = 0;
                    actualizarDatosPartida();
                    ventana.setConectado();
                } else if (mensaje.contains("[PARAR PARTIDA]")) {
                    lblPalabra.setText("Partida parada");
                    setActivarDesactivarControles(false);
                } else if (mensaje.contains("[PARAR PARTIDA FIN]")) {
                    setActivarDesactivarControles(false);
                    haGanado = true;
                    JOptionPane.showMessageDialog(null, "!Se ha adivinado la palabra!\nPalabra: " + datosPartida.getPalabra(), "Partida finalizada", JOptionPane.INFORMATION_MESSAGE);
                    desconectar();
                } else if (mensaje.contains("[LETRA FALLIDA]")) {
                    fallosUsuario++;
                } else if (mensaje.contains("[LETRA ACERTADA]")) {
                    aciertosUsuario++;
                } else {
                    txtMensajesRecibidos.append(Utilidades.Utils.getHoraActual() + mensaje + "\n");
                    System.out.println(Utilidades.Utils.getHoraActual() + mensaje);
                }
            } catch (IOException e) {
                //error provocado por el cierre del servidor
                JOptionPane.showMessageDialog(null, "Se ha perdido la comunicación con el servidor\n\n" + e.getMessage(), "Servidor desconectado", JOptionPane.ERROR_MESSAGE);
                conectado = false;
            } catch (ClassNotFoundException ex) {
                System.out.println(Utilidades.Utils.getHoraActual() + "ERROR " + ex);
            }
        }
    }

    private static String recibirMensaje() throws IOException {
        String mensaje = flujoEntrada.readUTF();
        return mensaje;
    }

    private static void recibirObjeto() throws IOException, ClassNotFoundException {
        DefaultListModel listaModelo = new DefaultListModel();
        Object objeto = flujoEntradaObjeto.readObject();
        if (objeto instanceof String[]) {
            String[] listadoUsuarios = (String[]) objeto;
            System.out.println(Utilidades.Utils.getHoraActual() + "Lista de usuarios: " + Arrays.toString(listadoUsuarios));
            for (int i = 0; i < listadoUsuarios.length; i++) {
                listaModelo.add(i, listadoUsuarios[i]);
            }
            listaUsuarios.setModel(listaModelo);
        } else if (objeto instanceof Utilidades.DatosPartida) {
            datosPartida = (Utilidades.DatosPartida) objeto;
            actualizarDatosPartida();
        }
    }

    private static void enviarMensaje(String mensaje) throws IOException {
        flujoSalida.writeUTF(datosConexion.getNombreUsuario() + " -> " + mensaje);
    }

    private static void enviarObjeto(Object objeto) throws IOException {
        flujoSalidaObjeto.writeObject(objeto);
    }

    private static void enviarDatosPartida() throws IOException {
        enviarMensaje("[OBJETO]");
        enviarObjeto(datosPartida);
    }

    public static void desconectar() throws IOException {
        if (!lblTurnoActual.getText().equals(nombreUsuario) || fallosUsuario >= 7 || haGanado) {
            if (!solicitadoCierre) {
                if (JOptionPane.showConfirmDialog(ventana, "¿Desea realmente salir del sistema?", "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    conectado = false;
                    if (usuario != null) {
                        solicitadoCierre = true;
                        System.out.println(Utilidades.Utils.getHoraActual() + "[USUARIO] Se ha realizado la petición de desconexión, usuario: " + usuario.toString());
                        enviarMensaje(DESCONEXION);
                        flujoSalida.close();
                        flujoSalidaObjeto.close();
                        flujoEntrada.close();
                        flujoEntradaObjeto.close();
                        System.out.println(Utilidades.Utils.getHoraActual() + "[USUARIO] Desconexión completada, usuario: " + usuario.toString());
                        JOptionPane.showMessageDialog(null, Utilidades.Utils.getHoraActual() + "La desconexión se ha realizado correctamente.", "Desconexión completada", JOptionPane.INFORMATION_MESSAGE);
                        usuario.close();
                        ventana.setDesconectado();
                        usuario = null;
                        ventana.dispose();
                    }
                }
            }
        } else {
            if (fallosUsuario < 7  && !haGanado) {
                JOptionPane.showMessageDialog(ventana, "No puede rendirse con la partida en curso, solicitelo una vez haya pasado su turno.");
            }
        }
    }

    //Bloquea la interacción del usuario con el juego, mientras no tiene el turno 
    //o la partida aún no ha iniciado, o acaba de terminar y se encuentra a la espera
    //de que se asigne una nueva palabra.
    private static void setActivarDesactivarControles(boolean estado) {
        listaBotones[3].setEnabled(estado);
        listaBotones[4].setEnabled(estado);
        txtLetrasEnviadas.setEnabled(estado);
        for (int i = 0; i < listaBtnTeclado.size(); i++) {
            listaBtnTeclado.get(i).setEnabled(estado);
        }
    }

    //Inhabilita los botones de las letras consultadas previamente.
    private static void compruebaLetrasConsultadas() {
        for (int i = 0; i < listaBtnTeclado.size(); i++) {
            if (lblPalabra.getText().contains(listaBtnTeclado.get(i).getText())
                    || txtLetrasFallidas.getText().contains(listaBtnTeclado.get(i).getText())) {
                listaBtnTeclado.get(i).setEnabled(false);
            }
        }
    }

    //Gestiona todos los datos y controles de la partida cada vez que estos son 
    //actualizados por otro usuario o por el servidor y recibidos en cada cliente.
    //También contiene la lógica del cliente, control de turno, y control de fallos.
    private static void actualizarDatosPartida() throws IOException {
        lblTurnoActual.setText(datosPartida.getTurnoActual());
        String palabra = datosPartida.getPalabra();
        if (!palabra.isEmpty() && datosPartida.getTurnoActual().equals(nombreUsuario)) {
            setActivarDesactivarControles(true);
        } else {
            setActivarDesactivarControles(false);
        }

        //Gestión de la visualización de la palabra a adivinar y el txtField con las letras fallidas.
        String cadena = "";
        for (int i = 0; i < palabra.length(); i++) {
            cadena += palabra.charAt(i) + " ";
        }
        lblPalabra.setText(cadena);
        String letrasFallidas = datosPartida.getLetrasFalladas();
        String cadena2 = "";
        for (int i = 0; i < letrasFallidas.length(); i++) {
            if (i < letrasFallidas.length() - 1) {
                cadena2 += letrasFallidas.charAt(i) + ", ";
            } else {
                cadena2 += letrasFallidas.charAt(i);
            }

        }
        txtLetrasFallidas.setText(cadena2);

        //Gestión de las etiquetas con estadísticas del juego e imágenes.
        lblFallos.setText(String.valueOf(fallosUsuario) + " / 7");
        lblAciertos.setText(String.valueOf(aciertosUsuario));
        lblImgAhorcado.setIcon(new ImageIcon("./src/img/ahorcado" + fallosUsuario + ".png"));
        compruebaLetrasConsultadas();
        ventana.repaint();
        if (fallosUsuario >= 7) {
            JOptionPane.showMessageDialog(ventana, "HA SIDO AHORCADO\n\t:(");
            enviarMensaje("Ha sido ahorcado.");
            desconectar();
        }
    }
}
