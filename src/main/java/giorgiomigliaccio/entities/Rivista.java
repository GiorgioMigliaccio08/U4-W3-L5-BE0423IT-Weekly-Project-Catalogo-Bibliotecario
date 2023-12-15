package giorgiomigliaccio.entities;

import javax.persistence.*;

@Entity
public class Rivista extends CatalogoBibliotecario {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {
        super("hhhhh", "Robin Hood", 2022, 300);
    }
}