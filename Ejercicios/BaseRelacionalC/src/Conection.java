
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



        /**
         * Aqui tenemos todas las especificaciones que requiere nuestra conexion
         * 1. driver
         * 2. el host
         * 3. el puerto, por defecto es el 5432
         * el sid
         * el usuario
         * La contraseña
         * juntamos_todo en la url
         */
        Connection conn = null;
        try{
            String driver = "jdbc:postgresql:";
            String host = "//localhost:";
            String porto = "5432";
            String sid = "postgres";
            String usuario = "postgres";
            String password = "postgres";
            String url = driver + host + porto + "/" + sid;
            conn = DriverManager.getConnection(url,usuario,password);

        }catch(SQLException e){
            System.out.println("Ups, ha ocurrido un error a la hora de conectarse a la base");
        }



        return conn;

    }


}