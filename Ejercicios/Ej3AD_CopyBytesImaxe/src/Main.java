import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Definimos las rutas de origen y destino de los archivos
        String rutaFile1 = "C:\\Users\\usuario\\Desktop\\carpeta\\foto1.jpg";  // Ruta del archivo origen
        String rutaFile2 = "C:\\Users\\usuario\\Desktop\\carpeta\\foto2.jpg";  // Ruta del archivo destino

        try {
            // Abrimos el archivo origen en modo de lectura con BufferedInputStream
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(rutaFile1));
            // Abrimos el archivo destino en modo de escritura con BufferedOutputStream y en modo apéndice (true) QUIERE DECIR QUE NO SE SOBREESCRIBIRA EL ARCHIVO
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(rutaFile2, true));

            int c;
            // Leemos el archivo origen byte por byte hasta el final
            while((c = bis.read()) != -1){
                // Escribimos cada byte leído en el archivo destino
                bos.write(c);
            }
            bos.close();  // Cerramos el flujo de salida
            System.out.println("Copiado con éxito");  // Mensaje indicando que la copia fue exitosa
        }
        catch (IOException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de entrada/salida
        }
    }
}
