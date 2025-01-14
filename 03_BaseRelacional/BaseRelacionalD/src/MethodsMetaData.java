
import java.sql.*;

/**
 * Clase con los metodos de consulta de información de la base de datos
 * @author cristian
 * @version 1.0
 */
public class MethodsMetaData {
    
    /**
     * Método que nos devuelve el numero de columnas de una tabla de la base de datos
     * @return el numero de columnas
     */
    public int obterNumeroColumnasTabla(){
        //consulta para saber el numero de columnas
        String consulta = "select codigo, descricion, prezo, datac from produtos";
        
        //iniciamos una variable a 0
        int numeroColumnas = 0;
        try{
            /**
             * 1. Nos conecamos a la base
             * 2. hacemos la consulta con statement ya que no lleva parámetros
             * 3. instanciamos un objeto de la clase ResultSetMetaData
             * 4. a través del resultset obtenemos los metadatos de la tabla
             * 5. iniciamos una variable igual al numero de columnas de la tabla a través del método correspondiente
             */
            Connection conn = ConexionBase.conectar();
            Statement st = conn.createStatement();
          

            ResultSet rs = st.executeQuery(consulta);
            
            ResultSetMetaData rmd = rs.getMetaData();
            
             numeroColumnas = rmd.getColumnCount();
            
            
        }catch(SQLException e){
            System.out.println("ups, no se pudo obtener el numero de columnas de la tabla");
        }
        
        return numeroColumnas;
    }
    
    /**
     * Método para saber el nombre de la columna de una tabla
     * @param posicion la posición de la columna para saber el nombre
     * @return el nombre de la columna
     */
    public String getColumnName(int posicion){
        
        //hacemos la consulta, misma que la de antes
        String consulta = "select codigo, descricion, prezo, datac from produtos";
        
        //el nombre de la columnas lo iniciamos en vacío
        String nombreColumna = "";
        try{
            
            /**
             * 1. hacemos la conexión a la base de datos
             * 2. creamos el objeto statement sin parámetros
             * 3. iniciamos los resultset y la clase con los metadatos
             * 4. llamamos al metodo que nos da el nombre de la columna y le pasamos la posición
             */
            Connection conn = ConexionBase.conectar();
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            nombreColumna = rsmd.getColumnName(posicion);
            
        }catch(SQLException e){
            System.out.println("ups, no se pudo obtener el nombre de la base");
        }
        return nombreColumna;
    }
    
    /**
     * Método para saber el tipo de columna que es de la tabla según posición
     * @param posicion la posición de la columna
     * @return el tipo de la columna
     */
    public String getColumnTypeName(int posicion){
        
        //preparamos la consulta
        String consulta = "select codigo, descricion, prezo, datac from produtos";
        
        //tipo de columna vacío
        String tipoColumna = "";
        try{
            /**
             * 1. Nos conectamos a la base de datos
             * 2. Hacemos el statement sin parámetros
             * 3. llamamos a los resultSets y a los metadatos de la tabla
             * 4. le damos valor al tipo de columna igual al metodo que nos devuelve el tipo de la tabla
             */
            Connection conn = ConexionBase.conectar();
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            tipoColumna = rsmd.getColumnTypeName(posicion);
            
        }catch(SQLException e){
            System.out.println("ups, no se pudo obtener el nombre de la base");
        }
        return tipoColumna;
    }
    
    
}
