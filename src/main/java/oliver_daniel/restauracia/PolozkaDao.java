package oliver_daniel.restauracia;

import java.util.List;

public interface PolozkaDao {

    void pridajPolozku(Polozka j);

    void vymazPolozku(Polozka j);

    List<Polozka> dajPolozky();

    Polozka dajPodlaId(Long id);

    Polozka dajIDPodlaNazvu(String nazov);
    
    public double dajCenuPolozky(String nazov);

}
