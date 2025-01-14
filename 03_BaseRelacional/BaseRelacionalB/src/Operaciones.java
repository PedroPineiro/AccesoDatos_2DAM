import java.sql.*;  // Importa todas las clases de la biblioteca JDBC

/**
 * Clase donde realizamos los métodos de las operaciones CRUD
 * para interactuar con la tabla de productos en una base de datos.
 *
 */
public class Operaciones {

    /**
     * Metodo para listar todos los elementos de una tabla.
     */
    public void listarContenido() {

        // Prepara la consulta SQL para seleccionar todos los registros de la tabla 'produtos'.
        String consulta = "select * from produtos";

        try {
            // Establece la conexión a la base de datos.
            Connection con = Conection.conectar();

            // Crea un Statement con propiedades "scrollable" (permite mover el cursor) y "updatable" (permite editar).
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecuta la consulta y obtiene el conjunto de resultados (ResultSet).
            ResultSet rs = st.executeQuery(consulta);

            // Recorre el ResultSet mientras haya registros.
            while (rs.next()) {
                // Lee los valores de cada columna en la fila actual del ResultSet.
                String codigo = rs.getString("codigo");
                String descricion = rs.getString("descricion");
                int prezo = rs.getInt("prezo");
                Date datac = rs.getDate("datac");

                // Imprime los datos de la fila en formato legible.
                System.out.println("Codigo: " + codigo + " | " + "Descripcion: " + descricion + " | " + "Precio: " + prezo + "€ | " + "Fecha: " + datac);
            }

        } catch (SQLException e) {
            // Captura y muestra un mensaje si ocurre una excepción SQL.
            System.out.println("Vaya, no se ha podido leer los registros de la base de datos");
        }
    }

    /**
     * Metodo para actualizar el precio de un producto especificado por su código.
     * @param codigo El código del producto a actualizar.
     * @param prezo El nuevo precio del producto.
     */
    public void updateProdutos(String codigo, int prezo) {

        // Prepara la consulta SQL para seleccionar el producto con el código especificado.
        String consulta = "select * from produtos where codigo = '" + codigo + "'";

        try {
            // Establece la conexión a la base de datos.
            Connection con = Conection.conectar();

            // Crea un Statement "scrollable" y "updatable".
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecuta la consulta y obtiene el ResultSet correspondiente al código del producto.
            ResultSet rs = st.executeQuery(consulta);

            // Verifica si el producto existe en el ResultSet.
            if (rs.next()) {
                // Actualiza el precio del producto.
                rs.updateInt("prezo", prezo);

                // Aplica los cambios en la base de datos.
                rs.updateRow();

                // Muestra mensaje de éxito.
                System.out.println("Producto actualizado con éxito");
            } else {
                System.out.println("No existe el código proporcionado");
            }

        } catch (SQLException e) {
            // Captura y muestra un mensaje si ocurre una excepción SQL.
            System.out.println("Vaya, ha habido un error a la hora de actualizar el producto");
        }
    }

    /**
     * Metodo para insertar un nuevo elemento en la tabla 'produtos'.
     * @param codigo El código del nuevo producto.
     * @param descricion La descripción del nuevo producto.
     * @param prezo El precio del nuevo producto.
     * @param datac La fecha asociada al nuevo producto.
     */
    public void insertarProdutos(String codigo, String descricion, int prezo, Date datac) {

        // Prepara la consulta SQL para seleccionar todos los registros de la tabla.
        String consulta = "select * from produtos";

        try {
            // Establece la conexión a la base de datos.
            Connection conn = Conection.conectar();

            // Crea un Statement "scrollable" y "updatable".
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecuta la consulta y obtiene el ResultSet de la tabla.
            ResultSet rs = st.executeQuery(consulta);

            // Mueve el cursor a una fila especial para realizar la inserción.
            rs.moveToInsertRow();

            // Define los valores de cada columna para el nuevo registro.
            rs.updateString("codigo", codigo);
            rs.updateString("descricion", descricion);
            rs.updateInt("prezo", prezo);
            rs.updateDate("datac", datac);

            // Inserta la nueva fila en la tabla.
            rs.insertRow();

            // Muestra mensaje de éxito.
            System.out.println("Elemento introducido con éxito en la tabla productos");

        } catch (SQLException e) {
            // Captura y muestra un mensaje si ocurre una excepción SQL.
            System.out.println("Vaya, no se pudo insertar los datos en la tabla");
        }
    }

    /**
     * Metodo para borrar un producto de la tabla 'produtos' dado su código.
     * @param codigo El código del producto a eliminar.
     */
    public void borrarFila(String codigo) {

        // Prepara la consulta SQL para seleccionar el producto con el código especificado.
        String consulta = "select * from produtos where codigo = '" + codigo + "'";

        try {
            // Establece la conexión a la base de datos.
            Connection con = Conection.conectar();

            // Crea un Statement "scrollable" y "updatable".
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // Ejecuta la consulta y obtiene el ResultSet del producto con el código dado.
            ResultSet rs = st.executeQuery(consulta);

            // Verifica si el producto existe en el ResultSet.
            if (rs.next()) {
                // Elimina la fila actual del ResultSet y de la base de datos.
                rs.deleteRow();

                // Muestra mensaje de éxito.
                System.out.println("Fila borrada con éxito");
            } else {
                System.out.println("No se encontró la fila a borrar");
            }

        } catch (SQLException e) {
            // Captura y muestra un mensaje si ocurre una excepción SQL.
            System.out.println("Vaya, no se pudo borrar el registro");
        }
    }
}
