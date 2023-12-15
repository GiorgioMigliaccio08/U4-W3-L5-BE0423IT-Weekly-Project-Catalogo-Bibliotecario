package giorgiomigliaccio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CatalogoBibliotecario {
    @Id
    @GeneratedValue
    private long id;
    private String codiceIsbn;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public CatalogoBibliotecario(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return codiceIsbn;
    }

    public void setIsbn(String isbn) {
        this.codiceIsbn = isbn;  // Correzione qui
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "CatalogoBibliotecario{" +
                "id=" + id +
                ", codiceIsbn='" + codiceIsbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}