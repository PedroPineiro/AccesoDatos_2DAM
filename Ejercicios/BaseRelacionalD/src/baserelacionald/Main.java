/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baserelacionald;

import javax.swing.JOptionPane;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {

    
    public static void main(String[] args) {
        
        //instanciamos el objeto con los métodos
        MethodsMetaData mmd = new MethodsMetaData();
        System.out.println("Metodo numero columnas de la tabla: ");
        
        //hacemos una variable igual al metodo que nos devuelve el número de columnas
        int numeroColumnas = mmd.obterNumeroColumnasTabla();
        
        //sacamos el resultado por pantalla
        System.out.println("Numero de columnas de la tabla produtos: " + numeroColumnas);
        System.out.println();
        
        System.out.println("Método nombre de la columna según número pasado: ");
        //pedimos al usuario que introduzca un numero
        int posicionNombre = Integer.parseInt(JOptionPane.showInputDialog("Introduce una posicion: "));
        //usamos un string que será igual al método que nos devuelve el nombre de la columna según la posicion dada
        String nombreColumna = mmd.getColumnName(posicionNombre);
        
        //lo sacamos por consola
        System.out.println("El nombre de la columna de la posición " + posicionNombre + " es: " + nombreColumna);
        System.out.println();
        
        System.out.println("Método nombre de la columna según número pasado: ");
        
        //pedimos al usuario que introduzca una posición
        int posicionTipo = Integer.parseInt(JOptionPane.showInputDialog("Introduce una posicion: "));
        
        //hacemos que un string sea igual al tipo de la columna según la posición dada
        String tipoColumna = mmd.getColumnTypeName(posicionTipo);
        
        //lo sacamos por consola
        System.out.println("El tipo de la columna de la posición " + posicionTipo + " es: " + tipoColumna);
        System.out.println();
        
        
        
    }
    
}
