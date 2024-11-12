
package baserelacionalc;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

    
    public static void main(String[] args) {
        
        //creamos el objeto de las operaciones crud
        OperacionesCrud oc = new OperacionesCrud();
        
        try {
            //este bloque está diseñado para transformar los datos de tipo Date
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/YYYY");
            java.util.Date di1;
            di1 = format.parse("6/4/2020");
            java.sql.Date df = new java.sql.Date(di1.getTime());
            
           
            oc.insireprep("p3", "tachas", 6, df);
        }catch(ParseException e){
            System.out.println("Ups, ha ocurrido un error con la fecha");
        }
        
        
        //llamamos a los metodos que hacen las operaciones crud
        oc.listarProductos();
        oc.actualizaProduto("p3", 12);
        oc.deleteProdutos("p3");
        
    }
    
}
