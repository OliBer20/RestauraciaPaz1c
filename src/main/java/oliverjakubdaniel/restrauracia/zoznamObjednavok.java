
package oliverjakubdaniel.restrauracia;

import java.util.ArrayList;
import java.util.List;


public class zoznamObjednavok {
    
  private  List<Objednavka> objednavky = new ArrayList<>();

    public List<Objednavka> getObjednavky() {
        return objednavky;
    }
  
  
    
    public zoznamObjednavok(){
   
        pridajObjednavku("Mesko na smotane", 2.5);
        pridajObjednavku("Zacykleny Baklazan", 4.5);
        pridajObjednavku("Cola 250ml", 1.0);
        pridajObjednavku("Grilovany Encian", 7.5);
 
        
    }
    
    public void pridajObjednavku(String nazov, double cena){
        Objednavka o = new Objednavka();
        o.setNazovJedla(nazov);
        o.setCenaJedla(cena);
        objednavky.add(o);
        
        
    }
    
    public List<Objednavka> vypisVsetkyObjednavky(){
        return objednavky;
    }
    
    
    
}
