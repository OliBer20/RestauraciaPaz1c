
package oliver_daniel.restauracia;

public interface UzivatelDao {
   
    uzivatel dajHeslo(String meno);
    
    void nastavHeslo(String meno, String heslo);
    
    void odstranVsetko();
    
}
