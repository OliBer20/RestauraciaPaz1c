package oliver_daniel.restauracia;

import java.util.List;
import oliver_daniel.restauracia.Objednavka;

public interface ObjednavkyDao {

    public List<Objednavka> dajVsetkyObjednavky();

     public Objednavka dajObjednavku(Long id);
    
     public void odstranObjednavku(Objednavka objednavka);
     
      public void pridajObjednavku(Objednavka objednavka);
    
    public List<Objednavka> dajDnesneObjednavky();
    
    void naplnObsahObjednavky(Objednavka objednavka);

    
 //   void vymazPredosluObjednavku();

}
