package dao;

import java.util.List;
import entity.Objednavka;

public interface ObjednavkyDao {

    public List<Objednavka> dajVsetkyObjednavky();

    public Objednavka dajObjednavku(Long id);

    public void odstranObjednavku(Objednavka objednavka);

    public void pridajObjednavku(Objednavka objednavka);

    public List<Objednavka> dajDnesneObjednavky();

    void naplnObsahObjednavky(Objednavka objednavka);

    void vymazPredosluObjednavku();

}
