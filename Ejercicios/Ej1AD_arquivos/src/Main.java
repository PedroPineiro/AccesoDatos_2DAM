public class Main {
    public static void main(String[] args) {
        String rutaDir = "C:\\Users\\usuario\\Desktop\\carpeta";
        String rutaFile= "C:\\Users\\usuario\\Desktop\\carpeta\\file.txt";

        Arquivos arquivos = new Arquivos();

        arquivos.eDirectorio(rutaDir);
        arquivos.eFicheiro(rutaFile);
        System.out.println("____________________________________________");
        arquivos.creaDirectorio("C:\\Users\\usuario\\Desktop\\carpeta\\carpeta1");
        arquivos.creaFicheiro(rutaFile,"file1.txt");
        System.out.println("____________________________________________");
        arquivos.modoAcceso(rutaFile);
        arquivos.calculaLonxitude(rutaDir,"file.txt");
        System.out.println("____________________________________________");
        arquivos.mLectura(rutaDir,"file1.txt");
        arquivos.mEscritura(rutaDir,"file1.txt");
        System.out.println("____________________________________________");
        arquivos.borraFicheiro(rutaDir,"file1.txt");
        arquivos.borraDirectorio("C:\\Users\\usuario\\Desktop\\carpeta\\carpeta1");

    }
}