package giorgiomigliaccio.dao;

import giorgiomigliaccio.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UtenteDAO {

    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("catalogobibliotecario");

    public void aggiungiUtente(Utente utente) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(utente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rimuoviUtente(long utenteId) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Utente utente = entityManager.find(Utente.class, utenteId);
        entityManager.remove(utente);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Utente cercaUtentePerId(long utenteId) {
        EntityManager entityManager = emFactory.createEntityManager();
        Utente utente = entityManager.find(Utente.class, utenteId);
        entityManager.close();
        return utente;
    }

    public Utente cercaUtentePerNumeroTessera(String numeroTessera) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.numeroTessera = :numeroTessera");
        query.setParameter("numeroTessera", numeroTessera);
        Utente utente = (Utente) query.getSingleResult();
        entityManager.close();
        return utente;
    }

    public List<Utente> cercaUtentiPerNome(String nome) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        List<Utente> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Utente> cercaUtentiPerCognome(String cognome) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM Utente u WHERE u.cognome LIKE :cognome");
        query.setParameter("cognome", "%" + cognome + "%");
        List<Utente> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }


    public static void closeEntityManagerFactory() {
        emFactory.close();
    }
}
