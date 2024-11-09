import java.io.*;

public class Main {
    public static void main(String[] args) {
        String rutaFile = "C:\\Users\\usuario\\Desktop\\carpeta\\file3.txt";
        String cadea = "o tempo está xélido";

        try {
            DataOutputStream dos= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(rutaFile)));

            System.out.println("Escribindo a cadea: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("Tamaño do fichero: " + dos.size() + " bytes");

            System.out.println("Escribindo a cadea: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("Tamaño do fichero: " + dos.size() + " bytes");

            System.out.println("Escribindo a cadea: " + cadea);
            dos.writeUTF(cadea);
            System.out.println("Tamaño do fichero: " + dos.size() + " bytes");

            System.out.println("Tamaño final do ficheiro: " + dos.size());
            dos.close();

            System.out.println("_______________________________________");

            DataInputStream dis= new DataInputStream(new BufferedInputStream(new FileInputStream(rutaFile)));

            while (dis.available() > 0) {
                System.out.println("Quedan: " + dis.available() + " bytes por ler");
                System.out.println("Lendo a cadea: " + dis.readUTF());
            }

            System.out.println("No queda nada por ler");
            dis.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}