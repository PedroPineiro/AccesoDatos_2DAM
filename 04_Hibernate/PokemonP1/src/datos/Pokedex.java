package datos;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pokedex")
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pokedex_id_gen")
    @SequenceGenerator(name = "pokedex_id_gen", sequenceName = "pokedex_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "peso", precision = 10, scale = 2)
    private double peso;

    @Column(name = "misc")
    @Type(type = "org.hibernate.type.TextType")
    private String misc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public Pokedex() {
    }

    public Pokedex(String nome, double peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", misc='" + misc + '\'' +
                '}';
    }
}