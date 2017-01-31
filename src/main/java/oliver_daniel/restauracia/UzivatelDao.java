
package oliver_daniel.restauracia;

import oliver_daniel.restauracia.uzivatel;

public interface UzivatelDao {
   
    uzivatel dajHeslo(String meno);
    
    void nastavHeslo(String meno, String heslo);
 
    
}
