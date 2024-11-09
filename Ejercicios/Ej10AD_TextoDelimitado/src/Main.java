import java.io.*; // Importamos las clases necesarias para el manejo de flujos de entrada y salida de archivos
import java.text.NumberFormat; // Importamos NumberFormat para dar formato de moneda

public class Main {
    public static void main(String[] args) {

        // Definimos los arrays con datos de productos
        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos", "tachas"};
        int[] prezo = {3, 4, 5};

        try {
            // Creamos un PrintWriter que escribirá en el fichero "produtos.txt", usando un BufferedWriter
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("produtos.txt")));

            // Recorremos los arrays y escribimos los datos de cada producto en el fichero
            for (int i = 0; i < cod.length; i++) {
                pw.println("Codigo:\t" + cod[i]); // Escribimos el código con un tabulador (\t) como delimitador
                pw.println("Descripcion: " + desc[i]); // Escribimos la descripción
                pw.println("Prezo: " + prezo[i] + NumberFormat.getCurrencyInstance().getCurrency().getSymbol()); // Formato de moneda
                pw.println(); // Línea en blanco entre registros para mejorar la legibilidad
            }
            pw.close(); // Cerramos el PrintWriter una vez terminado

            // Creamos un BufferedReader para leer el fichero "produtos.txt"
            BufferedReader br = new BufferedReader(new FileReader("produtos.txt"));

            // Leemos e imprimimos cada línea del fichero hasta que no haya más (null)
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // Mostramos cada línea en consola
            }
            br.close(); // Cerramos el BufferedReader una vez terminado

        } catch (Exception e) { // Capturamos cualquier excepción que pueda ocurrir
            System.out.println("Error: " + e.getMessage()); // Mostramos el mensaje de error
        }
    }
}
