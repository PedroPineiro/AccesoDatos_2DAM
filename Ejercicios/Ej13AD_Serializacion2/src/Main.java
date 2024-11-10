import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        // Arrays con los datos de los productos a serializar
        String[] cod = {"p1", "p2", "p3"};          // Códigos de los productos
        String[] desc = {"parafusos", "cravos", "tachas"};  // Descripciones de los productos
        int[] prezo = {3, 4, 5};                    // Precios de los productos

        // Serialización: Escribir objetos Product en un archivo
        try {
            // Creamos un flujo de salida para escribir en el archivo "products.dat"
            FileOutputStream fileOut = new FileOutputStream("products.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut); // Creamos el ObjectOutputStream

            // Creamos y escribimos tres objetos Product en el archivo
            for (int i = 0; i < cod.length; i++) {
                Product product = new Product(cod[i], desc[i], prezo[i]); // Creamos un nuevo objeto Product
                out.writeObject(product); // Escribimos el objeto Product en el archivo
            }

            // Escribimos un null para indicar el final de los objetos serializados
            out.writeObject(null);

            // Cerramos los flujos de salida
            out.close();
            fileOut.close();

            System.out.println("Objetos serializados correctamente."); // Mensaje de confirmación

        } catch (IOException e) {
            e.printStackTrace(); // En caso de error, imprimimos el stack trace
        }

        // Deserialización: Leer objetos Product desde el archivo
        try {
            // Creamos un flujo de entrada para leer desde el archivo "products.dat"
            FileInputStream fileIn = new FileInputStream("products.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn); // Creamos el ObjectInputStream

            // Leemos los objetos mientras no lleguemos a un null (que marca el final de los objetos)
            Object obj;
            while ((obj = in.readObject()) != null) { // Leemos un objeto del archivo
                if (obj instanceof Product) { // Verificamos que el objeto es una instancia de Product
                    Product product = (Product) obj; // Casteamos el objeto a Product
                    System.out.println(product); // Imprimimos el objeto Product
                }
            }

            // Cerramos los flujos de entrada
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // En caso de error, imprimimos el stack trace
        }
    }
}
