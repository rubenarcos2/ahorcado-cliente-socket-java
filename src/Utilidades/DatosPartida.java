package Utilidades;

import java.io.Serializable;

/**
 * Contiene los datos de la partida en curso.
 * Será transferido serializado por cliente-servidor.
 *
 * @author Rubén
 */
@SuppressWarnings("serial")
public class DatosPartida implements Serializable{

    private String palabra;
    private String letrasFalladas;
    private String consultaLetra;
    //Almacena el nombre del usuario por orden de conexión
    private String[] listaOrdenTurno;
    //Almacena el nommbre del usuario que está jugando
    private String turnoActual;

    public DatosPartida() {
        palabra = "";
        letrasFalladas = "";
        consultaLetra = "";
        listaOrdenTurno = null;
        turnoActual = "";
    }

    public DatosPartida(String palabra, String letrasFalladas, String consultaLetra, String[] listaOrdenTurno, String turnoActual) {
        this.palabra = palabra;
        this.letrasFalladas = letrasFalladas;
        this.consultaLetra = consultaLetra;
        this.listaOrdenTurno = listaOrdenTurno;
        this.turnoActual = turnoActual;
    }

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the letraFalladas
     */
    public String getLetrasFalladas() {
        return letrasFalladas;
    }

    /**
     * @param letrasFalladas the letrasFalladas to set
     */
    public void setLetrasFalladas(String letrasFalladas) {
        this.letrasFalladas = letrasFalladas;
    }

    /**
     * @return the consultaLetra
     */
    public String getConsultaLetra() {
        return consultaLetra;
    }

    /**
     * @param consultaLetra the consultaLetra to set
     */
    public void setConsultaLetra(String consultaLetra) {
        this.consultaLetra = consultaLetra;
    }

    /**
     * @return the listaOrdenTurno
     */
    public String[] getListaOrdenTurno() {
        return listaOrdenTurno;
    }

    /**
     * @param listaOrdenTurno the listaOrdenTurno to set
     */
    public void setListaOrdenTurno(String[] listaOrdenTurno) {
        this.listaOrdenTurno = listaOrdenTurno;
    }

    /**
     * @return the turnoActual
     */
    public String getTurnoActual() {
        return turnoActual;
    }

    /**
     * @param turnoActual the turnoActual to set
     */
    public void setTurnoActual(String turnoActual) {
        this.turnoActual = turnoActual;
    }
}
