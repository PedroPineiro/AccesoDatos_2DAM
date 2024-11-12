import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase main donde ejecutamos el programa
 * @author pedro
 */
public class Main {

    public static void main(String[] args) {

        //instanciamos la clase con los metodos
        Operaciones op = new Operaciones();

        //-----------------bloque de inserccion----------------------//

        try {
            //este bloque está diseñado para transformar los datos de tipo Date
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date di1;
            java.util.Date di2;
            java.util.Date di3;
            di1 = format.parse("27/12/2021");
            di2 = format.parse("3/7/2022");
            di3 = format.parse("6/4/2023");
            java.sql.Date df1 = new java.sql.Date(di1.getTime());
            java.sql.Date df2 = new java.sql.Date(di2.getTime());
            java.sql.Date df3 = new java.sql.Date(di3.getTime());

            //llamamos al metodo que inserta productos en la base de datos
            op.insireProducto("p1", "parafusos", 3, df1);
            op.insireProducto("p2", "cravos", 4, df2);
            op.insireProducto("p3", "tachas", 6, df3);

        }catch(ParseException e){
            System.out.println("Vaya, ha ocurrido un error con la fecha");
        }



        //------------------------------Bloque de lectura de datos---------------//

        //llamamos a los metodos que listan productos
        op.listaProductos();
        op.listaProductoPorCodigo("p1");

        //-----------------------------Bloque de actualizacion de datos-----------------//

        //llamamos al metodo que actualiza produtos
        op.actualizaPre(8, "p2");
        op.listaProductoPorCodigo("p2");

        //---------------------------Bloque de borrado-----------------------//

        //llamamos al metodo que elimina produtos
        op.eliminaProduto("p1");
        op.eliminaProduto("p2");
        op.eliminaProduto("p3");
    }
}