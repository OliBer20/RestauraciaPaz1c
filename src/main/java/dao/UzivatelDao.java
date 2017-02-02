
package dao;

import entity.uzivatel;
import entity.uzivatel;

public interface UzivatelDao {
   
    uzivatel dajHeslo(String meno);
    
    void nastavHeslo(String meno, String heslo);
 
    
}
