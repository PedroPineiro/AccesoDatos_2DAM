import java.io.*;  // Importamos las clases necesarias para trabajar con flujos de entrada y salida

public class Main {
    public static void main(String[] args) {
        // Definimos la ruta del archivo donde vamos a guardar los datos
        String rutaFile = "C:\\Users\\usuario\\Desktop\\carpeta\\file4.dat";
        // Definimos la cadena de texto que vamos a escribir en el archivo
        String cadea = "o tempo está xélido";

        try {
            // Creamos un DataOutputStream que se conecta a un BufferedOutputStream,
            // que a su vez se conecta a un FileOutputStream para escribir en el archivo.
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(rutaFile)));

            // Escribimos la cadena dos veces en el archivo
            for (int i = 0; i < 2; i++) {
                System.out.println("Escribindo a cadea: " + cadea);  // Imprimimos la cadena que estamos escribiendo
                dos.writeChars(cadea);  // Escribimos la cadena en el archivo (2 bytes por carácter)
                System.out.println("A lonxitude da cadea en caracteres é: " + cadea.length());  // Imprimimos la longitud de la cadena en caracteres
                System.out.println("Lévanse escritos: " + dos.size() + " bytes");  // Imprimimos los bytes escritos hasta ahora (esto puede causar error, ya que DataOutputStream no tiene el método size())
            }
            dos.close();  // Cerramos el flujo de salida de datos

            // Separa la salida para mayor claridad
            System.out.println("_______________________________________");

            // Creamos un DataInputStream que se conecta a un BufferedInputStream
            // que a su vez se conecta a un FileInputStream para leer del archivo.
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(rutaFile)));

            // Leemos el archivo mientras haya datos disponibles
            while (dis.available() > 0) {
                System.out.print("Lemos a cadea: ");  // Imprimimos que vamos a leer la cadena

                // Leemos cada carácter de la cadena, uno por uno (2 bytes por carácter)
                for (int i = 0; i < cadea.length(); i++) {
                    System.out.print(dis.readChar());  // Leemos un carácter del archivo
                }

                // Mostramos los bytes restantes por leer
                System.out.println("\nBytes restantes: " + dis.available());
            }

            System.out.println("Non quedan bytes por ler");  // Cuando ya no haya más datos para leer
            dis.close();  // Cerramos el flujo de entrada de datos

        } catch (IOException e) {
            e.printStackTrace();  // En caso de que ocurra un error, se imprime el error
        }
    }
}
