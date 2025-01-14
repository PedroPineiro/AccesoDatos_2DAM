import java.io.FileReader;  // Importamos la clase FileReader para leer caracteres de un archivo.
import java.io.FileWriter;  // Importamos la clase FileWriter para escribir caracteres a un archivo.

public class Main {
    public static void main(String[] args) {
        // Definimos las rutas de los archivos a leer y escribir.
        String rutaFile1 = "C:\\Users\\usuario\\Desktop\\carpeta\\file.txt";  // Ruta del archivo de origen (texto que vamos a copiar).
        String rutaFile2 = "C:\\Users\\usuario\\Desktop\\carpeta\\file2.txt"; // Ruta del archivo de destino (donde vamos a pegar el texto copiado).

        try {
            // Creamos un FileWriter para escribir en el archivo destino (file2.txt).
            FileWriter fw = new FileWriter(rutaFile2);

            // Creamos un FileReader para leer el archivo fuente (file.txt).
            FileReader fr = new FileReader(rutaFile1);

            int caracter;  // Variable para almacenar el valor de cada carácter leído.

            // Usamos un ciclo while para leer y escribir cada carácter.
            // El metodo fr.read() devuelve un entero, que es el código Unicode del carácter leído.
            // Si fr.read() retorna -1, significa que hemos llegado al final del archivo.
            while ((caracter = fr.read()) != -1) {
                // Escribimos el carácter leído en el archivo de destino.
                fw.write(caracter);
            }

            // Cerramos ambos flujos para liberar los recursos y asegurarnos de que los datos se guarden correctamente.
            fr.close();
            fw.close();

            // Mensaje de éxito indicando que el archivo se copió correctamente.
            System.out.println("Copiado correctamente");

        }
        catch (Exception e) {
            // Si ocurre algún error, se captura la excepción y se muestra el mensaje de error.
            System.out.println("Error: " + e.getMessage());
        }

    }
}
