import java.io.Serializable;

public class Product implements Serializable {
    private String codigo;
    private String descripcion;
    private int precio;

    // Constructor
    public Product(String codigo, String descripcion, int precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // toString para imprimir el objeto
    @Override
    public String toString() {
        return "Product [codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + "]";
    }
}
