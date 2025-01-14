package manager;

import config.HibernateConfig;
import datos.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class PokedexManager {

    public void insertarPokemon(Pokedex pokedex) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pokedex);
            transaction.commit();
            System.out.println("Pokemon insertado en la pokedex");
        } catch (Exception e) {
            System.out.println("Error al insertar el pokemon" + e.getMessage());
        }
    }

    public List<Pokedex> listarPokemons() {
        List<Pokedex> pokedex = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Pokedex> query= session.createQuery("from Pokedex ", Pokedex.class);
            pokedex= query.list();
            pokedex.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }
        return pokedex;
    }

    public void modificarPokemon(int id,String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class, id);
            if(pokedex!=null){
                pokedex.setNome(nome);
                session.update(pokedex);
                transaction.commit();
                System.out.println("Pokemon modificado en la pokedex");
            } else{
                System.out.println("No se encontro al pokemon en la pokedex con ese id ");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el pokemon: " + e.getMessage());
        }
    }

    public void borrarTabla() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery("DELETE FROM pokedex");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Tabla de pokemons borrada");
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla --> " + e.getMessage());
        }
    }

}
