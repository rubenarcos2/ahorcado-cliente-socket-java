package Utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Utilidad para la lectura del fichero con los valores de conexión.
 * @author Rubén
 */
public class LeerDatosConexionFichero {
    
    public static String[] getListaPalabras() throws IOException{
        String cadena = "";
        ArrayList<String> listaPalabras = new ArrayList<>();
        FileReader fichero = new FileReader("./src/Utilidades/datosConexion.txt");
        BufferedReader bufferLectura = new BufferedReader(fichero);
        while((cadena = bufferLectura.readLine())!=null) {
            listaPalabras.add(cadena);
        }
        bufferLectura.close();
        String[] lista = new String[listaPalabras.size()];
        for (int i = 0; i < listaPalabras.size(); i++) {
            lista[i] = listaPalabras.get(i);
        }
        return lista;
    }
    
}
