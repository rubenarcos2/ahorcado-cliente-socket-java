package Utilidades;

/**
 * Contiene los datos de conexión de la apliación cliente.
 * @author Rubén
 */
public class DatosConexion {

    private String host;
    private int puerto;
    private String nombreUsuario;

    public DatosConexion() {
        host = "";
        puerto = -1;
        nombreUsuario = "";
    }

    /**
     * Devuelve el nombre/IP del host
     *
     * @return la IP de acceso al host
     */
    public String getHost() {
        return host;
    }

    /**
     * Asigna el nombre/IP de acceso al servidor
     *
     * @param host
     * @throws java.lang.Exception en caso de estar vacío
     */
    public void setHost(String host) throws Exception {
        if (host.isEmpty()) {
            throw new Exception("Nombre de usuario vacío");
        } else {
            this.host = host;
        }
    }

    /**
     * Devuelve el número de puerto usado como conexión externa para acceder al
     * servidor.
     *
     * @return el puerto de conexión
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * Asigna el número de puerto usado como conexión externa para acceder al
     * servidor.
     *
     * @param puerto
     * @throws java.lang.Exception en caso de estar fuera de rango o no ser
     * numérico
     */
    public void setPuerto(int puerto) throws Exception {
        if (puerto < 1024 || puerto > 49151) {
            throw new Exception("Puerto fuera de rango");
        } else {
            this.puerto = puerto;
        }
    }

    /**
     * Devuelve el nombre de usuario (nick) que se utilizará durante la
     * conexión.
     *
     * @return el nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Asigna el nombre de usuario (nick) que se utilizará durante la conexión.
     *
     * @param nombreUsuario
     * @throws java.lang.Exception en caso de estar vacío
     */
    public void setNombreUsuario(String nombreUsuario) throws Exception {
        if (nombreUsuario.isEmpty()) {
            throw new Exception("Nombre de usuario vacío");
        } else {
            this.nombreUsuario = nombreUsuario;
        }
    }
}
