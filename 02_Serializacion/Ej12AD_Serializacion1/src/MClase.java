import java.io.Serializable;

public class MClase implements Serializable {
    String nome;

    // Si descomentas la siguiente línea y marcas 'numero1' como 'transient',
    // esta variable no se almacenará en el proceso de serialización.
    // transient int numero1;

    int numero1;  // Esta variable sí será serializada
    double numero2;

    // Constructor vacío para inicializar los valores por defecto
    public MClase() {
    }

    // Constructor con parámetros para inicializar los valores
    public MClase(String nome, int numero1, double numero2) {
        this.nome = nome;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
}
