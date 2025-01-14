import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Definimos las rutas de los archivos: uno de origen y uno de destino
        String rutaFile1 = "C:\\Users\\usuario\\Desktop\\carpeta\\file.txt"; // Ruta del archivo de origen
        String rutaFile2 = "C:\\Users\\usuario\\Desktop\\carpeta\\file2.txt"; // Ruta del archivo de destino

        try {
            // Creamos un FileInputStream para leer el archivo de origen
            FileInputStream fis = new FileInputStream(rutaFile1);

            // Creamos un FileOutputStream para escribir el archivo de destino
            FileOutputStream fos = new FileOutputStream(rutaFile2);

            // Variable para almacenar los bytes leídos
            int c;

            // Bucle para leer los bytes del archivo de origen hasta llegar al final (cuando fis.read() devuelve -1)
            while ((c = fis.read()) != -1) {
                // Escribimos el byte leído en el archivo de destino
                fos.write(c);
            }

            // Cerramos el archivo de destino después de escribir todos los bytes
            fos.close();

            // Imprimimos un mensaje indicando que la copia se realizó con éxito
            System.out.println("Copiado con éxito");
        } catch (IOException e) {
            // Si ocurre una excepción, la imprimimos en la consola
            e.printStackTrace();
        }
    }
}

// También podemos copiar archivos con un buffer de bytes de tamaño fijo (por ejemplo, 1024 bytes) para mejorar el rendimiento. En este caso, el código sería el siguiente:
        /*
        try (FileInputStream fis = new FileInputStream(rutaFile1);
             FileOutputStream fos = new FileOutputStream(rutaFile2)) {

            byte[] buffer = new byte[1024]; // Array de bytes de 1024 posiciones (1 KB)
            int bytesRead;

            // Bucle para leer y escribir bloques de bytes
            while ((bytesRead = fis.read(buffer)) != -1) { // Si el archivo tiene menos de 1024 bytes, bytesRead será menor que 1024. Cuando llega al final del archivo, fis.read() devuelve -1 y el bucle se detiene
                fos.write(buffer, 0, bytesRead); // Escribe los bytes desde buffer en rutaFile2, desde la posición 0 hasta bytesRead
            }

            System.out.println("Copiado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }

         */