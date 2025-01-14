package manager;

import config.HibernateConfig;
import datos.Adestrador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class AdestradorManager {

    public void insertarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(adestrador);
            transaction.commit();
            System.out.println("Nuevo adestrador insertado");
        } catch (Exception e) {
            System.out.println("Error al insertar el adestrador" + e.getMessage());
        }
    }

    public List<Adestrador> listarAdestradores() {
        List<Adestrador> adestradores = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Adestrador> query= session.createQuery("from Adestrador ", Adestrador.class);
            adestradores= query.list();
            adestradores.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los adestradores: " + e.getMessage());
        }
        return adestradores;
    }

    public void modificarAdestrador(int id,String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, id);
            if(adestrador!=null){
                adestrador.setNome(nome);
                session.update(adestrador);
                transaction.commit();
                System.out.println("Adestrador modificado en la pokedex");
            } else{
                System.out.println("No se encontro al adestrador con ese id ");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el adestrador: " + e.getMessage());
        }
    }

    public void borrarTabla(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createSQLQuery("DELETE FROM adestrador");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Tabla de adestradores borrada");
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla de adestradores: " + e.getMessage());
        }
    }
}
