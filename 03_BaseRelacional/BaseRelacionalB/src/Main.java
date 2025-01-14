import java.sql.*;

/**
 * Clase main donde ejecutamos la aplicacion
 * @author pedro
 */
public class Main {


    public static void main(String[] args) {

        //instanciamos el objeto de los metodos y los ejecutamos
        Operaciones op = new Operaciones();

        System.out.println("Listamos todos los elementos:");
        op.listarContenido();
        System.out.println("_________________________________________________________");

        System.out.println("Actualizamos un produto");
        op.updateProdutos("p2", 8);
        System.out.println("_________________________________________________________");

        System.out.println("Insertamos un nuevo elemento");
        op.insertarProdutos("p4", "martelo", 20, null);
        System.out.println("_________________________________________________________");

        System.out.println("Borramos un elemento");
        op.borrarFila("p4");
    }

}