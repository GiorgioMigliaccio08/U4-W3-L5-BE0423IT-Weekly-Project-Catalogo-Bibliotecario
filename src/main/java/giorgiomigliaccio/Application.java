package giorgiomigliaccio;

import giorgiomigliaccio.dao.CatalogoBibliotecarioDAO;
import giorgiomigliaccio.dao.PrestitoDAO;
import giorgiomigliaccio.dao.UtenteDAO;
import giorgiomigliaccio.entities.CatalogoBibliotecario;
import giorgiomigliaccio.entities.Prestito;
import giorgiomigliaccio.entities.Utente;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {

    private static UtenteDAO utenteDAO;
    private static PrestitoDAO prestitoDAO;
    private static Prestito utente;

    public static void main(String[] args) {
       // Inizializzo l'EntityManagerFactory che fa riferimento alla classe Catalogo Bibliotecario
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("catalogobibliotecario");

        CatalogoBibliotecarioDAO catalogoDAO = new CatalogoBibliotecarioDAO();

        // Aggiungo diversi elementi al CatalogoBibliotecario
        CatalogoBibliotecario ElementoUno = new CatalogoBibliotecario("sg3-ghe", "Robin Hood", 2022, 300);
        catalogoDAO.aggiungiElemento(ElementoUno);


        CatalogoBibliotecario ElementoDue = new CatalogoBibliotecario("hu0-gha", "Il ladro di sogni", 2008, 500);
        catalogoDAO.aggiungiElemento(ElementoDue);


        CatalogoBibliotecario ElementoTre = new CatalogoBibliotecario("nv4-mlq", "Spiderman", 2012, 150);
        catalogoDAO.aggiungiElemento(ElementoTre);

        // Aggiungo diversi utenti al Catalogo Bibliotecario
        Utente UtenteUno = new Utente("0001", "Giorgio", "Migliaccio", LocalDate.of(2000, 1, 1));
        utenteDAO.aggiungiUtente(UtenteUno);

        Utente UtenteDue = new Utente("0002", "Giacomo", "Poretti", LocalDate.of(1998, 3, 7));
        utenteDAO.aggiungiUtente(UtenteDue);

        Utente UtenteTre = new Utente("0003", "Martin", "Garrix", LocalDate.of(2002, 2, 6));
        utenteDAO.aggiungiUtente(UtenteTre);

        //Prestiti
        Prestito prestitoUno = new Prestito(UtenteUno, ElementoUno, LocalDate.now(), LocalDate.now().plusDays(14));
        prestitoDAO.aggiungiPrestito(prestitoUno);

        Prestito prestitoDue = new Prestito(UtenteDue, ElementoDue, LocalDate.now(), LocalDate.now().plusDays(14));
        prestitoDAO.aggiungiPrestito(prestitoDue);

        Prestito prestitoTre = new Prestito(UtenteTre, ElementoTre, LocalDate.now(), LocalDate.now().plusDays(14));
        prestitoDAO.aggiungiPrestito(prestitoTre);

        // Rimozione di un elemento del catalogo dato un codice ISBN
        catalogoDAO.rimuoviElementoByIsbn("123456");


        //Ricerca per ISBN
        String isbnCercato = "sg3-ghe";
        CatalogoBibliotecario libroTrovato = catalogoDAO.cercaPerIsbn(isbnCercato);
        System.out.println("Libro trovato per ISBN " + isbnCercato + ": " + libroTrovato);

        // Ricerca per anno pubblicazione
        int annoPubblicazioneCercato = 2022;
        List<CatalogoBibliotecario> libriPerAnno = catalogoDAO.cercaPerAnnoPubblicazione(annoPubblicazioneCercato);
        System.out.println("Libri trovati per anno di pubblicazione " + annoPubblicazioneCercato + ": " + libriPerAnno);

        // Ricerca per autore
        String autoreCercato = "AutoreLibro";
        List<CatalogoBibliotecario> libriPerAutore = catalogoDAO.cercaPerAutore(autoreCercato);
        System.out.println("Libri trovati per autore " + autoreCercato + ": " + libriPerAutore);

        // Ricerca per titolo o parte di esso
        String titoloCercato = "Robin";
        List<CatalogoBibliotecario> libriPerTitolo = catalogoDAO.cercaPerTitolo(titoloCercato);
        System.out.println("Libri trovati per titolo contenente " + titoloCercato + ": " + libriPerTitolo);

        // Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
        List<Prestito> prestitiUtente = prestitoDAO.cercaPrestitiPerUtente(utente.getId());
        System.out.println("Prestiti per l'utente " + utente.getNome() + " " + utente.getCognome() + ": " + prestitiUtente);

        // Ricerca di tutti i prestiti scaduti e non ancora restituiti
        List<Prestito> prestitiScaduti = prestitoDAO.cercaPrestitiScadutiNonRestituiti();
        System.out.println("Prestiti scaduti e non restituiti: " + prestitiScaduti);



        emFactory.close();
    }
}
