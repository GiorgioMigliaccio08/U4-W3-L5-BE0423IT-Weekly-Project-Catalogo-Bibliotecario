package giorgiomigliaccio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Libro extends CatalogoBibliotecario {
    @Id
    @GeneratedValue
    private long id;

    private String autore;
    private String genere;

    public Libro(String autore, String genere ) {
        super("hhhhh", "Robin Hood", 2022, 300);
        this.autore = autore;
        this.genere= genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
