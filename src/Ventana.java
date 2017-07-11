
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ventana del CLIENTE de comunicaciones
 * -------------------------------------
 * @author Rubén
 */
public class Ventana extends javax.swing.JFrame implements WindowListener, ActionListener {

    private ArrayList<JButton> listaBtnTeclado;

    public Ventana() {
        initComponents();
        //setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("./img/ahorcado_icono.jpg")));
        this.setTitle("Cliente de ahorcado");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        listaBtnTeclado = new ArrayList<>();
        crearTeclado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        pnlJuego = new javax.swing.JPanel();
        lblPalabra = new javax.swing.JLabel();
        txtEnviarLetra = new javax.swing.JTextField();
        lblLetrasFallidas = new javax.swing.JLabel();
        txtLetrasFallidas = new javax.swing.JTextField();
        lblImgAhorcado = new javax.swing.JLabel();
        btnAdivinar = new javax.swing.JButton();
        btnRendirse = new javax.swing.JButton();
        pnlTeclado = new javax.swing.JPanel();
        lblAciertosTexto = new javax.swing.JLabel();
        lblAciertos = new javax.swing.JLabel();
        lblFallos = new javax.swing.JLabel();
        lblFallosTexto = new javax.swing.JLabel();
        lblTurnoUsuarioTexto = new javax.swing.JLabel();
        lblTurnoUsuario = new javax.swing.JLabel();
        btnEnviarLetra = new javax.swing.JButton();
        lblEstadoConexion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnChat = new javax.swing.JToggleButton();
        pnlChat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList();
        lblUsuarios = new javax.swing.JLabel();
        btnEnviarMensaje = new javax.swing.JButton();
        txtMensajesEnviados = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaMensajesRecibidos = new javax.swing.JTextArea();
        lblChat = new javax.swing.JLabel();
        lblArchivos1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmVentanaServido"); // NOI18N
        setResizable(false);

        lblPalabra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPalabra.setText("Esperando inicio...");

        txtEnviarLetra.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtEnviarLetra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEnviarLetra.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtEnviarLetra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnviarLetraFocusGained(evt);
            }
        });
        txtEnviarLetra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEnviarLetraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEnviarLetraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnviarLetraKeyTyped(evt);
            }
        });

        lblLetrasFallidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLetrasFallidas.setText("Letras fallidas:");
        lblLetrasFallidas.setName("etiquetaArchivos"); // NOI18N

        txtLetrasFallidas.setEditable(false);
        txtLetrasFallidas.setName("cajaArchivos"); // NOI18N

        lblImgAhorcado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ahorcado0.png"))); // NOI18N

        btnAdivinar.setText("Adivinar palabra");

        btnRendirse.setText("Rendirse");

        javax.swing.GroupLayout pnlTecladoLayout = new javax.swing.GroupLayout(pnlTeclado);
        pnlTeclado.setLayout(pnlTecladoLayout);
        pnlTecladoLayout.setHorizontalGroup(
            pnlTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTecladoLayout.setVerticalGroup(
            pnlTecladoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        lblAciertosTexto.setText("Letras acertadas:");

        lblAciertos.setText("0");

        lblFallos.setText("0 / 7");

        lblFallosTexto.setText("Fallos:");

        lblTurnoUsuarioTexto.setText("Turno actual (jugando):");

        lblTurnoUsuario.setText("-");

        btnEnviarLetra.setText("Consultar letra");
        btnEnviarLetra.setName("btnEnviarLetra"); // NOI18N

        lblEstadoConexion.setText("Estado servidor");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnChat.setSelected(true);
        btnChat.setText("Ocultar chat");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addComponent(btnEnviarLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnviarLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblLetrasFallidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLetrasFallidas)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addComponent(btnAdivinar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRendirse, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblImgAhorcado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addComponent(lblAciertosTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAciertos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFallosTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFallos))))
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addComponent(lblTurnoUsuarioTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTurnoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addComponent(lblEstadoConexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuegoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJuegoLayout.createSequentialGroup()
                        .addComponent(lblPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addComponent(lblLetrasFallidas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLetrasFallidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdivinar)
                                    .addComponent(btnRendirse))
                                .addGap(18, 18, 18)
                                .addComponent(pnlTeclado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEnviarLetra, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(btnEnviarLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlJuegoLayout.createSequentialGroup()
                                .addComponent(lblImgAhorcado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAciertosTexto)
                                    .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblFallosTexto)
                                        .addComponent(lblFallos)
                                        .addComponent(lblAciertos)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTurnoUsuarioTexto)
                            .addComponent(lblTurnoUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChat)
                            .addComponent(lblEstadoConexion))
                        .addContainerGap())
                    .addComponent(jSeparator2)))
        );

        listaUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaUsuarios.setName("listaUsuarios"); // NOI18N
        jScrollPane2.setViewportView(listaUsuarios);

        lblUsuarios.setText("Lista de usuarios conectados");
        lblUsuarios.setName("etiquetaListaUsuarios"); // NOI18N

        btnEnviarMensaje.setText("Enviar");
        btnEnviarMensaje.setActionCommand("btnEnviar");
        btnEnviarMensaje.setName("btnEnviarMensaje"); // NOI18N

        txtMensajesEnviados.setName("cajaMensajesEnviados"); // NOI18N

        txtAreaMensajesRecibidos.setColumns(20);
        txtAreaMensajesRecibidos.setRows(5);
        txtAreaMensajesRecibidos.setName("cajaMensajesRecibidos"); // NOI18N
        jScrollPane3.setViewportView(txtAreaMensajesRecibidos);

        lblChat.setText("Actividad del chat");
        lblChat.setName("etiquetaActividadChat"); // NOI18N

        lblArchivos1.setText("Envío de mensaje a todos los usuarios");
        lblArchivos1.setName("etiquetaMesanjeEnviado"); // NOI18N

        javax.swing.GroupLayout pnlChatLayout = new javax.swing.GroupLayout(pnlChat);
        pnlChat.setLayout(pnlChatLayout);
        pnlChatLayout.setHorizontalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMensajesEnviados)
                    .addComponent(lblArchivos1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(lblChat, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChatLayout.createSequentialGroup()
                        .addComponent(lblUsuarios)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlChatLayout.setVerticalGroup(
            pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarios)
                    .addComponent(lblChat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblArchivos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMensajesEnviados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarMensaje, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearTeclado() {
        pnlTeclado.setLayout(new GridLayout(6, 5));
        for (int i = 0; i < 27; i++) {
            listaBtnTeclado.add(new JButton(String.valueOf((char) (i + 65))));
            listaBtnTeclado.get(i).addActionListener(this);
            listaBtnTeclado.get(i).setEnabled(false);
            pnlTeclado.add(listaBtnTeclado.get(i));
            if (i == 13) {
                listaBtnTeclado.add(new JButton("Ñ"));
                listaBtnTeclado.get(i).addActionListener(this);
                listaBtnTeclado.get(i).setEnabled(false);
                pnlTeclado.add(listaBtnTeclado.get(i));
            }
        }

    }

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        if (btnChat.isSelected()) {
            btnChat.setSelected(true);
            btnChat.setText("Ocultar chat");
            pnlChat.setVisible(true);
            this.pack();
        } else {
            pnlChat.setVisible(false);
            btnChat.setSelected(false);
            btnChat.setText("Ver chat");
            this.pack();
        }
    }//GEN-LAST:event_btnChatActionPerformed

    private void txtEnviarLetraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnviarLetraKeyTyped
        //txtEnviarLetra.setText(String.valueOf(Character.toUpperCase(evt.getKeyChar())));
        if (txtEnviarLetra.getText().length() == 1) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEnviarLetraKeyTyped

    private void txtEnviarLetraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnviarLetraKeyPressed
        txtEnviarLetra.setText(String.valueOf(Character.toUpperCase(evt.getKeyChar())));
    }//GEN-LAST:event_txtEnviarLetraKeyPressed

    private void txtEnviarLetraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnviarLetraFocusGained
        txtEnviarLetra.setText("");
    }//GEN-LAST:event_txtEnviarLetraFocusGained

    private void txtEnviarLetraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnviarLetraKeyReleased
        if (txtEnviarLetra.getText().length() == 1) {
            evt.consume();
        } 
    }//GEN-LAST:event_txtEnviarLetraKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdivinar;
    private javax.swing.JToggleButton btnChat;
    private javax.swing.JButton btnEnviarLetra;
    private javax.swing.JButton btnEnviarMensaje;
    private javax.swing.JButton btnRendirse;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAciertos;
    private javax.swing.JLabel lblAciertosTexto;
    private javax.swing.JLabel lblArchivos1;
    private javax.swing.JLabel lblChat;
    private javax.swing.JLabel lblEstadoConexion;
    private javax.swing.JLabel lblFallos;
    private javax.swing.JLabel lblFallosTexto;
    private javax.swing.JLabel lblImgAhorcado;
    private javax.swing.JLabel lblLetrasFallidas;
    private javax.swing.JLabel lblPalabra;
    private javax.swing.JLabel lblTurnoUsuario;
    private javax.swing.JLabel lblTurnoUsuarioTexto;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JList listaUsuarios;
    private javax.swing.JPanel pnlChat;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlTeclado;
    private javax.swing.JTextArea txtAreaMensajesRecibidos;
    private javax.swing.JTextField txtEnviarLetra;
    private javax.swing.JTextField txtLetrasFallidas;
    private javax.swing.JTextField txtMensajesEnviados;
    // End of variables declaration//GEN-END:variables

    public JButton[] getListaBotones() {
        JButton[] listaBotones = new JButton[5];
        listaBotones[0] = btnEnviarMensaje;
        listaBotones[1] = btnRendirse;
        listaBotones[2] = null;
        listaBotones[3] = btnEnviarLetra;
        listaBotones[4] = btnAdivinar;
        return listaBotones;
    }

    public ArrayList<JButton> getListaBtnTeclado() {
        return listaBtnTeclado;
    }

    public JList getListaUsuarios() {
        return listaUsuarios;
    }

    public JLabel getLblFallos() {
        return lblFallos;
    }

    public JLabel getLblAciertos() {
        return lblAciertos;
    }

    public JLabel getLblPalabra() {
        return lblPalabra;
    }

    public JLabel getLblTurnoUsuario() {
        return lblTurnoUsuario;
    }

    public JLabel getLblImgAhorcado() {
        return lblImgAhorcado;
    }

    public JTextArea getTxtAreaMensajesRecibidos() {
        return txtAreaMensajesRecibidos;
    }

    public JTextField getTxtMensajesEnviados() {
        return txtMensajesEnviados;
    }

    public JTextField getTxtEnviarLetra() {
        return txtEnviarLetra;
    }

    public JTextField getTxtLetrasFallidas() {
        return txtLetrasFallidas;
    }

    public void setTxtLetrasFallidas(JTextField txtLetrasFallidas) {
        this.txtLetrasFallidas = txtLetrasFallidas;
    }

    public JLabel getLblEstadoConexion() {
        return lblEstadoConexion;
    }

    public void setConectado() {
        lblEstadoConexion.setText("Estado del servidor: conectado");
    }

    public void setDesconectado() {
        lblEstadoConexion.setText("Estado del servidor: desconectado");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        setDesconectado();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            Cliente.desconectar();
        } catch (IOException ex) {
            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR en la desconexión: " + ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            Cliente.desconectar();
        } catch (IOException ex) {
            System.out.println(Utilidades.Utils.getHoraActual() + "ERROR al desconectar: " + ex);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        for (int i = 0; i < listaBtnTeclado.size(); i++) {
            if (listaBtnTeclado.get(i).getActionCommand().equals(e.getActionCommand())) {
                txtEnviarLetra.setText(e.getActionCommand());
            }
        }
    }
}
