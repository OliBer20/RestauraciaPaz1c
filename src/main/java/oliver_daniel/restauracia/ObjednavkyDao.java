package oliver_daniel.restauracia;

import java.util.List;

public interface ObjednavkyDao {

    List<Objednavka> dajObjednavky();

    void pridaj(Objednavka objednavka);
    
    void Odstran(Objednavka objednavka);
    
    void odstranVsetko();
    
    void vymazPredosluObjednavku();

}