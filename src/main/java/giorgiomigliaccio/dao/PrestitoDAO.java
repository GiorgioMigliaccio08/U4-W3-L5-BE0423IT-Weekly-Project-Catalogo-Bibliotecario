package giorgiomigliaccio.dao;

import giorgiomigliaccio.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PrestitoDAO {

    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("catalogobibliotecario");

    public void aggiungiPrestito(Prestito prestito) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(prestito);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rimuoviPrestito(long prestitoId) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Prestito prestito = entityManager.find(Prestito.class, prestitoId);
        entityManager.remove(prestito);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Prestito cercaPrestitoPerId(long prestitoId) {
        EntityManager entityManager = emFactory.createEntityManager();
        Prestito prestito = entityManager.find(Prestito.class, prestitoId);
        entityManager.close();
        return prestito;
    }

    public List<Prestito> cercaPrestitiPerUtente(long utenteId) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :utenteId");
        query.setParameter("utenteId", utenteId);
        List<Prestito> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Prestito> cercaPrestitiScadutiNonRestituiti() {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL");
        List<Prestito> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }
    public static void closeEntityManagerFactory() {
        emFactory.close();
    }
}