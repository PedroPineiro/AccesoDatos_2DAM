import java.io.*; // Importamos las clases necesarias para el manejo de flujos de entrada y salida de archivos

public class Main {
    public static void main(String[] args) {
        // Especificamos las rutas de los archivos de entrada (file.txt) y salida (file2.txt)
        String rutaFile1 = "C:\\Users\\usuario\\Desktop\\carpeta\\file.txt";
        String rutaFile2 = "C:\\Users\\usuario\\Desktop\\carpeta\\file2.txt";

        try {
            // Creamos un BufferedReader para leer el contenido del archivo de entrada
            // FileReader lee el archivo de texto, y BufferedReader lo envuelve para mejorar la eficiencia de lectura
            BufferedReader br = new BufferedReader(new FileReader(rutaFile1));

            // Creamos un PrintWriter para escribir el contenido en el archivo de salida
            // BufferedWriter mejora la eficiencia de escritura al usar un buffer intermedio
            // FileWriter permite escribir en el archivo
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(rutaFile2)));

            // Variable para almacenar cada línea leída
            String linea;

            // Leemos el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Escribimos cada línea leída en el archivo de salida
                pw.println(linea); // println añade un salto de línea automáticamente después de escribir
            }

            // Cerramos ambos flujos de entrada y salida
            br.close();
            pw.close();

            // Mensaje de éxito
            System.out.println("Copiado correctamente");

        }
        catch (Exception e) {
            // Si ocurre algún error, se muestra el mensaje de excepción
            System.out.println("Error: " + e.getMessage());
        }
    }
}
