import java.io.FileNotFoundException; // Importa la excepción para cuando un archivo no se encuentra
import java.io.IOException; // Importa la excepción para errores de entrada/salida
import java.io.RandomAccessFile; // Importa la clase RandomAccessFile para trabajar con archivos de acceso aleatorio

public class Main {

    // Arrays estáticos que contienen los datos de productos
    static String[] codes = {"p1", "p2", "p3"}; // Códigos de los productos
    static String[] descricion = {"parafusos", "cravos", "tachas"}; // Descripciones de los productos
    static int[] prices = {3, 4, 5}; // Precios de los productos en enteros

    public static void main(String[] args) {

        // Bloque try-with-resources para asegurar que el archivo se cierra automáticamente
        try (RandomAccessFile raf = new RandomAccessFile("productos.dat", "rw")) { // "rw" indica modo lectura-escritura

            // Bucle para escribir cada producto en el archivo
            for (int i = 0; i < codes.length; i++) {
                // Escribe el código del producto en el archivo, ajustado a 3 caracteres
                raf.writeChars(formatString(codes[i], 3));

                // Escribe la descripción del producto en el archivo, ajustada a 10 caracteres
                raf.writeChars(formatString(descricion[i], 10));

                // Escribe el precio del producto como un valor entero (4 bytes)
                raf.writeInt(prices[i]);
            }

            // Mueve el puntero al principio del archivo para comenzar la lectura
            raf.seek(0);

            // Bucle para leer y mostrar cada registro hasta el final del archivo
            while (raf.getFilePointer() < raf.length()) {
                // Lee 3 caracteres para el código y los almacena en un array de caracteres
                char[] codeChars = new char[3];
                for (int i = 0; i < 3; i++) {
                    codeChars[i] = raf.readChar(); // Lee un carácter y lo guarda en el array
                }
                String code = new String(codeChars).trim(); // Convierte el array a String y elimina espacios en blanco

                // Lee 10 caracteres para la descripción y los almacena en un array de caracteres
                char[] descricionChars = new char[10];
                for (int i = 0; i < 10; i++) {
                    descricionChars[i] = raf.readChar(); // Lee un carácter y lo guarda en el array
                }
                String descricion = new String(descricionChars).trim(); // Convierte a String y elimina espacios

                // Lee el precio del producto como un entero
                int price = raf.readInt();

                // Muestra el producto en la consola
                System.out.println("Código: " + code);
                System.out.println("Descrición: " + descricion);
                System.out.println("Prezo: " + price);
            }

        } catch (FileNotFoundException e) { // Excepción si el archivo no existe
            e.printStackTrace(); // Imprime el error
        } catch (IOException e) { // Excepción general de entrada/salida
            e.printStackTrace(); // Imprime el error
        }
    }

    // Metodo para ajustar una cadena a una longitud específica con espacios si es necesario
    private static String formatString(String str, int length) {
        // Aplica formato a la cadena para que ocupe 'length' caracteres, completando con espacios a la derecha
        return String.format("%-" + length + "s", str).replace(' ', ' '); // No cambia espacios, pero se puede modificar
    }
}
