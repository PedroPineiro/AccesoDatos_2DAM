import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Definimos la ruta y la cadena a escribir
        String rutaFile = "C:\\Users\\usuario\\Desktop\\carpeta\\file5.dat";
        String cadea = "Está en casa";

        try {
            // Creamos un DataOutputStream, usando BufferedOutputStream para mayor eficiencia
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(rutaFile)));

            // Primera escritura con writeUTF
            System.out.println("WriteUTF escribindo: " + cadea);
            dos.writeUTF(cadea);  // Escribimos la cadena en formato UTF
            System.out.println("Bytes totais escritos: " + dos.size());

            // Segunda escritura con writeChars
            System.out.println("WriteChars escribindo: " + cadea);
            dos.writeChars(cadea);  // Escribimos la cadena en formato de caracteres
            System.out.println("Bytes totais escritos: " + dos.size());

            // Tercera escritura con writeUTF
            System.out.println("WriteUTF escribindo: " + cadea);
            dos.writeUTF(cadea);  // Escribimos la cadena de nuevo en formato UTF
            System.out.println("Bytes totais escritos: " + dos.size());

            // Cerramos el flujo de salida
            dos.close();

            System.out.println("_______________________________________");

            // Creamos un DataInputStream para leer el archivo
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaFile)));

            // Leemos la primera cadena con readUTF
            System.out.println("Lendo a primeira cadea con UTF: " + dis.readUTF());
            System.out.println("Quedan: " + dis.available() + " bytes por ler");

            // Leemos la segunda cadena con readChar usando un bucle
            System.out.print("Lendo a segunda cadea con Chars: ");
            for (int i = 0; i < cadea.length(); i++) {
                System.out.print(dis.readChar());  // Leemos cada carácter individualmente
            }
            System.out.println("\nQuedan: " + dis.available() + " bytes por ler");

            // Leemos la tercera cadena con readUTF
            System.out.println("Lendo a terceira cadea con UTF: " + dis.readUTF());
            System.out.println("Quedan: " + dis.available() + " bytes por ler");

            // Cerramos el flujo de entrada
            dis.close();

        } catch (IOException e) {
            e.printStackTrace();  // En caso de error, mostramos la traza de la excepción
        }
    }
}
