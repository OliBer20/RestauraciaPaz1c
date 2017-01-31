package oliver_daniel.restauracia;

import java.util.List;
import oliver_daniel.restauracia.Objednavka;

public interface ObjednavkyDao {

    List<Objednavka> dajObjednavky();

    void pridaj(Objednavka objednavka);
    
    void Odstran(Objednavka objednavka);
    
    public List<Objednavka> dajDnesneObjednavky();
    
    void odstranVsetko();
    
    void vymazPredosluObjednavku();

}
