
package dao;

import entity.Objednavka;
import java.util.List;


public interface vypisDao {
    
     public List<Objednavka> dajVsetkyObjednavky();
     
     public List<Objednavka> dajDnesneObjednavky();
     
     public List<Objednavka> dajPodlaMesiaca(int rok, int mesiac);
     
     public List<Objednavka> dajPodlaRoka(int rok);
     
     public List<Objednavka> dajPodlaDatumu(int rok, int mesiac, int den);
     
     
    
}
