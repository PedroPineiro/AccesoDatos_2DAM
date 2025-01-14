package datos;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "adestrador")
public class Adestrador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adestrador_id_gen")
    @SequenceGenerator(name = "adestrador_id_gen", sequenceName = "adestrador_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    private Date nacemento;

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

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public Adestrador() {
    }

    public Adestrador(String nome, Date nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}