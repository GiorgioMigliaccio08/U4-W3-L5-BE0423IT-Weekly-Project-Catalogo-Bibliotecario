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



        emFactory.close();
    }
}
