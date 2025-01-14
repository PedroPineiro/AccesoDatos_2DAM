import java.io.*;

public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase MClase con valores iniciales
        MClase obx = new MClase("ola", -7, 2.7E10);

        try {
            // Crear un ObjectOutputStream para escribir el objeto en un archivo 'serial.dat'
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial.dat"));
            oos.writeObject(obx);  // Escribir el objeto en el archivo
            oos.close();  // Cerrar el flujo de salida

            MClase obx2;  // Objeto vacío para leer los datos del archivo
            // Crear un ObjectInputStream para leer el objeto desde el archivo 'serial.dat'
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial.dat"));
            obx2 = (MClase) ois.readObject();  // Leer el objeto y castear a MClase
            ois.close();  // Cerrar el flujo de entrada

            // Mostrar los valores del objeto recuperado
            System.out.println(obx2.nome + ", " + obx2.numero1 + ", " + obx2.numero2);

        }
        catch (IOException e) {
            e.printStackTrace();  // Manejar posibles errores de I/O
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);  // Manejar el error si no se encuentra la clase
        }
    }
}