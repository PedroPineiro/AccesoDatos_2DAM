package manager;

import config.HibernateConfig;
import datos.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class PokemonManager {

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

    public void listarPokemons() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.createQuery("from Pokedex ", Pokedex.class).list().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void modificarPokemon_enPokedex(int id,String nome) {
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

    public void eliminarPokemon_enPokedex(int id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class, id);
            if (pokedex != null) {
                session.delete(pokedex);
                System.out.println("Pokemon eliminado de la pokedex");
            } else {
                System.out.println("No se encontro al pokemon en la pokedex ");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el pokemon en la pokedex: " + e.getMessage());
        }
    }

    public void borrarTabla() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery("DELETE FROM pokedex");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Tabla borrada");
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla --> " + e.getMessage());
        }
    }
}
