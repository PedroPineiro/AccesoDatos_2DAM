import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            // Crear un flujo de salida para escribir en "produtos.txt" utilizando buffering para eficiencia
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("produtos.txt")));

            // Crear y escribir el primer producto (pr) en el archivo
            Product pr = new Product("cod1", "parafusos", 3.0);
            dos.writeUTF(pr.getCodigo());       // Escribir código
            dos.writeUTF(pr.getDescripcion());  // Escribir descripción
            dos.writeDouble(pr.getPrecio());    // Escribir precio

            // Crear y escribir el segundo producto (pr2) en el archivo
            Product pr2 = new Product("cod2", "cravos", 4.0);
            dos.writeUTF(pr2.getCodigo());
            dos.writeUTF(pr2.getDescripcion());
            dos.writeDouble(pr2.getPrecio());

            // Crear y escribir el tercer producto (pr3) en el archivo
            Product pr3 = new Product("cod3", "tachas", 6.0);
            dos.writeUTF(pr3.getCodigo());
            dos.writeUTF(pr3.getDescripcion());
            dos.writeDouble(pr3.getPrecio());

            // Crear y escribir el cuarto producto (pr4) en el archivo
            Product pr4 = new Product("cod4", "grapas", 2.0);
            dos.writeUTF(pr4.getCodigo());
            dos.writeUTF(pr4.getDescripcion());
            dos.writeDouble(pr4.getPrecio());

            // Cerrar el flujo de escritura después de guardar todos los productos
            dos.close();
            System.out.println("Produtos gardados en 'produtos.txt'\n");

            // Crear un flujo de entrada para leer desde "produtos.txt" con buffering
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("produtos.txt")));

            // Crear un único objeto `po3` para reutilizar en cada lectura de producto
            Product po3 = new Product();

            // Bucle para leer datos hasta que no queden bytes disponibles en el archivo
            while (dis.available() > 0) {
                // Leer y asignar los valores del producto actual en el archivo al objeto `po3`
                po3.setCodigo(dis.readUTF());       // Leer y establecer código
                po3.setDescripcion(dis.readUTF());  // Leer y establecer descripción
                po3.setPrecio(dis.readDouble());    // Leer y establecer precio

                // Imprimir los detalles de `po3` para mostrar el producto leído
                System.out.println(po3.getCodigo() + " , " + po3.getDescripcion() + " , " + po3.getPrecio());
            }
            // Cerrar el flujo de lectura una vez que se han leído todos los datos
            dis.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }
}
