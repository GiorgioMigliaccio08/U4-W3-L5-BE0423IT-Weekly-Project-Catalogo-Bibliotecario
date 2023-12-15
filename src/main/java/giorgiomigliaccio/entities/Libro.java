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
        super();
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
}
