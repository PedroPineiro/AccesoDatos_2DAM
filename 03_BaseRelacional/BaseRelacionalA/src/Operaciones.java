import java.sql.*;

/**
 * Clase que contiene los metodos para realizar operaciones en la base de datos
 * @author pedro
 * @version 1.0
 */
public class Operaciones {

    /**
     * Metodo que inserta registros en nuestra base de datos
     * @param codigo el codigo del producto
     * @param descricion la descripcion del producto
     * @param prezo el precio del producto
     * @param datac la fecha de caducidad
     */
    public void insireProducto(String codigo, String descricion, float prezo, Date datac) {

        // Definimos la consulta de inserción con placeholders para parámetros
        String consulta = "insert into produtos (codigo, descricion, prezo, datac) values(?, ?, ?, ?)";

        // Envolvemos el proceso en un bloque try-catch para manejar posibles excepciones SQL
        try {
            // Establecemos la conexión llamando al metodo conectar() de la clase Conection
            Connection conn = Conection.conectar();
            // Preparamos la consulta con PreparedStatement para insertar los valores
            PreparedStatement ps = conn.prepareStatement(consulta);

            // Configuramos los parámetros de la consulta en cada posición (1 = primer ?, etc.)
            ps.setString(1, codigo);
            ps.setString(2, descricion);
            ps.setFloat(3, prezo);
            ps.setDate(4, datac);

            // Ejecutamos la consulta de actualización y guardamos el número de filas afectadas
            int insercciones = ps.executeUpdate();

            // Verificamos si se insertó alguna fila y mostramos el mensaje correspondiente
            if (insercciones > 0) {
                System.out.println("Insercción realizada con éxito");
            } else {
                System.out.println("Ups, ha ocurrido un error al insertar el producto");
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar conectar a la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar todos los elementos de la tabla productos en la base de datos
     */
    public void listaProductos() {

        // Definimos la consulta para seleccionar todos los registros
        String consulta = "select * from produtos";
        try {
            // Conectamos a la base de datos
            Connection conn = Conection.conectar();
            PreparedStatement ps = conn.prepareStatement(consulta);
            // Ejecutamos la consulta y obtenemos los resultados en un ResultSet
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre cada registro en el ResultSet
            while (rs.next()) {
                // Obtenemos cada campo por nombre y los mostramos
                String codigo = rs.getString("codigo");
                String descricion = rs.getString("descricion");
                float prezo = rs.getFloat("prezo");
                Date datac = rs.getDate("datac");
                System.out.println("Codigo: " + codigo + " | " + "Descripcion: " + descricion + " | " + "Precio: " + prezo + "€ | " + "Fecha: " + datac);
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar leer los registros de la base de datos");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para listar un producto específico por su codigo
     * @param codigo del producto a buscar
     */
    public void listaProductoPorCodigo(String codigo) {

        // Definimos la consulta con un placeholder para el código
        String consulta = "select * from produtos where codigo = ?";
        try {
            // Conectamos a la base de datos
            Connection conn = Conection.conectar();
            // Preparamos la consulta con PreparedStatement
            PreparedStatement ps = conn.prepareStatement(consulta);
            // Establecemos el valor del parámetro (1 = primer ?)
            ps.setString(1, codigo);
            // Ejecutamos la consulta y obtenemos el ResultSet
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre los resultados y mostramos cada campo del producto
            while (rs.next()) {
                String dameCodigo = rs.getString("codigo");
                String descricion = rs.getString("descricion");
                float prezo = rs.getFloat("prezo");
                Date datac = rs.getDate("datac");
                System.out.println("Codigo: " + codigo + " | " + "Descripcion: " + descricion + " | " + "Precio: " + prezo + "€ | " + "Fecha: " + datac);
            }

        } catch (SQLException e) {
            System.out.println("Error al intentar leer el registro específico");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar el precio de un producto específico según su código
     * @param prezo el precio del producto actualizado
     * @param codigo el codigo del producto a actualizar
     */
    public void actualizaPre(float prezo, String codigo) {

        // Definimos la consulta de actualización con placeholders
        String consulta = "update produtos set prezo = ? where codigo = ?";

        try {
            // Conectamos a la base de datos
            Connection conn = Conection.conectar();
            // Preparamos la consulta con PreparedStatement
            PreparedStatement ps = conn.prepareStatement(consulta);
            // Establecemos los valores de los parámetros
            ps.setFloat(1, prezo);
            ps.setString(2, codigo);

            // Ejecutamos la actualización y guardamos el número de filas afectadas
            int actualizacion = ps.executeUpdate();

            // Verificamos si se actualizó alguna fila
            if (actualizacion > 0) {
                System.out.println("Actualización realizada con éxito");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar actualizar el producto");
            e.printStackTrace();
        }
    }

    /**
     * Metodo para borrar un producto de la base de datos según su codigo
     * @param codigo del producto a eliminar
     */
    public void eliminaProduto(String codigo) {

        // Definimos la consulta de eliminación con un placeholder para el código
        String consulta = "delete from produtos where codigo = ?";

        try {
            // Conectamos a la base de datos
            Connection conn = Conection.conectar();
            // Preparamos la consulta con PreparedStatement
            PreparedStatement ps = conn.prepareStatement(consulta);
            // Establecemos el valor del parámetro
            ps.setString(1, codigo);
            // Ejecutamos la eliminación y guardamos el número de filas afectadas
            int eliminacion = ps.executeUpdate();

            // Verificamos si se eliminó alguna fila
            if (eliminacion > 0) {
                System.out.println("Borrado realizado con éxito");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar borrar el registro");
            e.printStackTrace();
        }
    }
}
