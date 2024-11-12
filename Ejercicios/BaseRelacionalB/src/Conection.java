import java.sql.*;

/**
 * Clase para establecer la conexion a la base de datos
 * @author pedro
 */
public class Conection {

    /**
     * Metodo para establecer una conexion con la base de datos
     * @return el objeto de tipo Conexion
     */
    public static Connection conectar(){

        String driver = "jdbc:postgresql:";
        String host = "//localhost:";
        String porto = "5432";
        String sid = "postgres";
        String usuario = "postgres";
        String password = "postgres";
        String url = driver + host + porto + "/" + sid;

        // Inicializamos el objeto Connection en null (se conectará más adelante)
        Connection conn = null;

        try {
            // Intentamos establecer la conexión usando el objeto DriverManager y los parámetros anteriores
            conn = DriverManager.getConnection(url, usuario, password);

        } catch (SQLException e) {
            // Si ocurre un error al conectar, capturamos la excepción y mostramos un mensaje de error
            System.out.println("Vaya, ha ocurrido un error al conectarse");
            // Imprimimos el error completo para ayudar en el diagnóstico (opcional en un entorno de producción)
            e.printStackTrace();
        }

        // Retornamos el objeto Connection que representa la conexión a la base de datos (o null si falló)
        return conn;
    }
}
