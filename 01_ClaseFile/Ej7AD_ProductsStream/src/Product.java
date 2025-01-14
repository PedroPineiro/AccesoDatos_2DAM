public class Product {
    // Atributos privados de la clase Product
    private String codigo;       // Código del producto
    private String descripcion;  // Descripción del producto
    private double precio;       // Precio del producto

    // Constructor por defecto que inicializa las propiedades con valores predeterminados
    public Product() {
        this.codigo = null;      // Inicializa el código a null
        this.descripcion = null; // Inicializa la descripción a null
        this.precio = 0.0;       // Inicializa el precio a 0.0
    }

    // Constructor parametrizado que asigna valores específicos a las propiedades
    public Product(String codigo, String descripcion, double precio) {
        this.codigo = codigo;      // Asigna el código pasado como argumento
        this.descripcion = descripcion; // Asigna la descripción pasada como argumento
        this.precio = precio;      // Asigna el precio pasado como argumento
    }

    // Metodo getter para obtener el código del producto
    public String getCodigo() {
        return codigo;  // Devuelve el valor de la propiedad 'codigo'
    }

    // Metodo setter para cambiar el código del producto
    public void setCodigo(String codigo) {
        this.codigo = codigo;  // Asigna el nuevo valor al código
    }

    // Metodo getter para obtener la descripción del producto
    public String getDescripcion() {
        return descripcion;  // Devuelve el valor de la propiedad 'descripcion'
    }

    // Metodo setter para cambiar la descripción del producto
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;  // Asigna el nuevo valor a la descripción
    }

    // Metodo getter para obtener el precio del producto
    public double getPrecio() {
        return precio;  // Devuelve el valor de la propiedad 'precio'
    }

    // Metodo setter para cambiar el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;  // Asigna el nuevo valor al precio
    }
}

