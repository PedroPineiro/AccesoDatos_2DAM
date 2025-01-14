
import java.sql.*;

/**
 * Clase donde realizamos las operaciones crud en la base de datos
 * @author pedro
 */
public class Operaciones {

    /**
     * Metodo para meter valores en la base de datos
     * @param codigo el codigo del producto
     * @param descricion la descricion del produto
     * @param prezo el precio del produto
     * @param datac la fecha del produto
     */
    public void insireprep(String codigo, String descricion, int prezo, Date datac){

        //preparamos la consulta con interrogaciones
        String consulta = "insert into produtos values(?,?,?,?)";

        try{
            /**
             * Pasos para realizar la conexion:
             * 1. Creamos un objeto de tipo conexion que será igual a un metodo que nos devuelve una conexion a la base de datos
             * 2. La consulra tiene parametros, así que instanciamos el objeto de tipo PreparedStatemente
             * 3. llamamos a los metodos que set para insertar registros
             * 4. los numeros entre parentesis en los set son las posiciones de los interrogantes
             * 5. comprobamos la inserccion con un if
             */
            Connection conn = Conection.conectar();
            PreparedStatement st = conn.prepareStatement(consulta);
            st.setString(1, codigo);
            st.setString(2, descricion);
            st.setInt(3,prezo);
            st.setDate(4, datac);

            int insercciones = st.executeUpdate();

            if(insercciones > 0){
                System.out.println("Insercciones compleadas en la tabla");
            }

        }catch(SQLException e){
            System.out.println("ups, no se pudo insertar los productos en la tabla");
        }

    }
    /**
     * Metodo para listar los elementos de una base de datos
     */
    public void listarProductos(){

        //preparamos la consulta
        String consulta = "select * from produtos";
        try{
            /**
             * Pasos para realizar la conexion:
             * 1. Creamos un objeto de tipo conexion que será igual a un metodo que nos devuelve una conexion a la base de datos
             * 2. Preparamos un objeto de tipo preparedStatement pese a que no es necesario ya que no tiene parámetros la consulta
             * 3. Instanciaimos un objeto de tipo ResultSet para recoger el resultado de la consulta que le pasamos por parametro al metodo executeQuery()
             * 4. Recogemos los valores en el bucle while con los metodos de la clase ResultSey
             * 5. imprimimos
             */
            Connection conn = Conection.conectar();
            PreparedStatement st = conn.prepareStatement(consulta);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                String codigo = rs.getString("codigo");
                String descricion = rs.getString("descricion");
                int prezo = rs.getInt("prezo");
                Date datac = rs.getDate("datac");
                System.out.println("Codigo: " + codigo + "\n" +
                        "Descricion: " + descricion + "\nPrezo: " + prezo + "€" +
                        "\nfecha: " + datac);
            }
        }catch(SQLException ex){

        }
    }
    /**
     * Metodo para actualizar los elementos de una base de datos
     * @param prezo el precio del producto
     * @param codigo el codigo del producto
     */
    public void actualizaProduto(String codigo, int prezo){

        //preparamos la consulta
        String consulta = "update produtos set prezo = ? where codigo = ?";

        try{

            /**
             * Pasos para actualizar el registro:
             * 1. Establecemos conexion con la base de datos
             * 2. preparamos el PreparedStatement con la consulta
             * 3. añadimos el nuevo precio segun el codigo
             * 4. comprobamos que se actualizo el producto
             */
            Connection conn = Conection.conectar();
            PreparedStatement st = conn.prepareStatement(consulta);

            st.setString(2,codigo);
            st.setInt(1, prezo);

            int actualizacion = st.executeUpdate();

            if(actualizacion > 0){
                System.out.println("Prezo del codigo " + codigo + " actualizado correctamente");
            }


        }catch(SQLException e){
            System.out.println("Ups, no se pudo actualizar el producto");
        }
    }

    /**
     * Metodo para borrar un elemento de la base de datos
     * @param codigo del producto
     */
    public void deleteProdutos(String codigo){
        //preparamos la consulta
        String consulta = "delete from produtos where codigo = ?";

        /**
         * Pasos para realizar el borrado:
         * 1. Conexion a la base de datos
         * 2. Preparar el objeto de tipo PreparesStatement, ya que la consulta va con parametros
         * 3. Introducimos el codigo
         * 4. comprobamos si se elimino
         */
        try{
            Connection conn = Conection.conectar();
            PreparedStatement st = conn.prepareStatement(consulta);

            st.setString(1,codigo);

            int borrado = st.executeUpdate();

            if(borrado > 0){
                System.out.println("Productos borrados correctamente");
            }

        }catch(SQLException e){
            System.out.println("ups, no se pudo borrar el producto");
        }
    }

}
