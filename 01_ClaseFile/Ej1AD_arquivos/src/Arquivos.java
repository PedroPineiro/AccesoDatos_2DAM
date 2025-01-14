import java.io.File;

public class Arquivos {

    // Función para comprobar si la ruta proporcionada es un directorio
    public void eDirectorio(String rutaDir){
        File file = new File(rutaDir);  // Crea un objeto File con la ruta proporcionada
        try{
            if(file.exists()){  // Verifica si el archivo o directorio existe
                if(file.isDirectory()){  // Comprueba si es un directorio
                    System.out.println("É un directorio");
                }
                else{
                    System.out.println("Non é un directorio");  // Si no es un directorio, es un archivo
                }
            }
            else{
                System.out.println("Directorio inexistente");  // Si no existe
            }
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para comprobar si la ruta proporcionada es un archivo
    public void eFicheiro(String rutaFile){
        File file = new File(rutaFile);  // Crea un objeto File con la ruta proporcionada
        try{
            if(file.exists()){  // Verifica si el archivo existe
                if(file.isFile()){  // Comprueba si es un archivo regular
                    System.out.println("É un ficheiro");
                }
                else{
                    System.out.println("Non é un ficheiro");  // Si no es un archivo, es un directorio
                }
            }
            else{
                System.out.println("Fichero inexistente");  // Si no existe el archivo
            }
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para crear un directorio en la ruta proporcionada
    public void creaDirectorio(String rutaDir){
        File file = new File(rutaDir);  // Crea un objeto File con la ruta proporcionada
        try{
            if(file.exists()){  // Verifica si ya existe un directorio con ese nombre
                System.out.println("Ya existe un directorio con ese nombre");
            }
            else{
                file.mkdir();  // Crea el directorio
                System.out.println("Directorio creado");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para crear un archivo en el directorio especificado
    public void creaFicheiro(String rutaDir, String nameFile){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        File file = new File(rutaDir, nameFile);  // Crea un objeto File con la ruta del archivo
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(file.exists()){  // Si el archivo ya existe
                    System.out.println("Ya existe un fichero con ese nombre");
                }
                else{
                    file.createNewFile();  // Crea el archivo
                    System.out.println("Ficheiro creado");
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para comprobar los permisos de acceso (lectura y escritura) de un archivo
    public void modoAcceso(String rutaFile){
        File file = new File(rutaFile);  // Crea un objeto File con la ruta proporcionada
        try{
            if(file.exists()){  // Verifica si el archivo existe
                if (file.canWrite())  // Comprueba si el archivo tiene permisos de escritura
                    System.out.println("Escritura si");
                else
                    System.out.println("Escritura no");
                if (file.canRead())  // Comprueba si el archivo tiene permisos de lectura
                    System.out.println("Lectura si");
                else
                    System.out.println("Lectura no");
            }
            else{
                System.out.println("Ficheiro inexistente");  // Si el archivo no existe
            }
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para calcular la longitud (tamaño) de un archivo
    public void calculaLonxitude(String rutaDir, String nameFile){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        File file = new File(rutaDir, nameFile);  // Crea un objeto File con la ruta del archivo
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(file.exists()){  // Si el archivo existe
                    System.out.println("Lonxitude: " + file.length());  // Muestra el tamaño del archivo
                }
                else{
                    System.out.println("Ficheiro invalido");  // Si el archivo no existe
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para poner un archivo en modo solo lectura
    public void mLectura(String rutaDir, String nameFile){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        File file = new File(rutaDir, nameFile);  // Crea un objeto File con la ruta del archivo
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(file.exists()){  // Si el archivo existe
                    file.setReadOnly();  // Establece el archivo como solo lectura
                    System.out.println("O ficheiro agora é de só lectura");
                }
                else{
                    System.out.println("Ficheiro invalido");  // Si el archivo no existe
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para habilitar la escritura en un archivo
    public void mEscritura(String rutaDir, String nameFile){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        File file = new File(rutaDir, nameFile);  // Crea un objeto File con la ruta del archivo
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(file.exists()){  // Si el archivo existe
                    file.setWritable(true);  // Permite la escritura en el archivo
                    System.out.println("Agora pódese escribir no ficheiro");
                }
                else{
                    System.out.println("Ficheiro invalido");  // Si el archivo no existe
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para borrar un archivo
    public void borraFicheiro(String rutaDir, String nameFile){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        File file = new File(rutaDir, nameFile);  // Crea un objeto File con la ruta del archivo
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(file.exists()){  // Si el archivo existe
                    file.delete();  // Elimina el archivo
                    System.out.println("Ficheiro borrado con éxito");
                }
                else{
                    System.out.println("Ficheiro inexistente");  // Si el archivo no existe
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }

    // Función para borrar un directorio
    public void borraDirectorio(String rutaDir){
        File ruta = new File(rutaDir);  // Crea un objeto File con la ruta del directorio
        try{
            if(ruta.exists() && ruta.isDirectory()){  // Verifica si la ruta es válida y es un directorio
                if(ruta.delete()){  // Si el directorio se puede eliminar
                    System.out.println("Directorio borrado con éxito");
                }
                else{
                    System.out.println("Directorio inexistente");  // Si el directorio no existe
                }
            }
            else System.out.println("Ruta invalida");  // Si la ruta no es válida
        } catch (Exception e) {
            e.printStackTrace();  // Captura y muestra el error
        }
    }
}
