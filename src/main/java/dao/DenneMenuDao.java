package dao;

import entity.Polozka;
import java.util.List;

public interface DenneMenuDao {

    void pridaj(Long id);

    void odober(Polozka p);

    void vymazVsetko();

    List<Polozka> ziskajDenneMenu();

}
