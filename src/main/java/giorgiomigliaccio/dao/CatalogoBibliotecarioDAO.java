package giorgiomigliaccio.dao;

import giorgiomigliaccio.entities.CatalogoBibliotecario;

import javax.persistence.*;
import java.util.List;


public class CatalogoBibliotecarioDAO {

    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("catalogobibliotecario");

    public void aggiungiElemento(CatalogoBibliotecario elemento) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(elemento);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void rimuoviElementoByIsbn(String isbn) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("DELETE FROM CatalogoBibliotecario c WHERE c.codiceIsbn = :isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public CatalogoBibliotecario cercaPerIsbn(String isbn) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.codiceIsbn = :isbn");
        query.setParameter("isbn", isbn);
        CatalogoBibliotecario risultato = (CatalogoBibliotecario) query.getSingleResult();
        entityManager.close();
        return risultato;
    }

    public List<CatalogoBibliotecario> cercaPerAnnoPubblicazione(int anno) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.annoPubblicazione = :anno");
        query.setParameter("anno", anno);
        List<CatalogoBibliotecario> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<CatalogoBibliotecario> cercaPerAutore(String autore) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.autore = :autore");
        query.setParameter("autore", autore);
        List<CatalogoBibliotecario> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<CatalogoBibliotecario> cercaPerTitolo(String titolo) {
        EntityManager entityManager = emFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.titolo LIKE :titolo");
        query.setParameter("titolo", "%" + titolo + "%");
        List<CatalogoBibliotecario> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }
    public static void closeEntityManagerFactory() {
        emFactory.close();
    }
}
