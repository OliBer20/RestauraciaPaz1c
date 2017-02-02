package dao;

import entity.Polozka;
import java.util.List;

public interface PolozkaDao {

    void pridajPolozku(Polozka j);

    void vymazPolozku(Polozka j);

    List<Polozka> dajPolozky();

    Polozka dajPodlaId(Long id);

    Polozka dajPodlaNazvu(String nazov);

}
