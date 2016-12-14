
package oliver_daniel.restauracia;

public interface HeslaDao {
   
    uzivatel dajHeslo(String meno);
    
    void nastavHeslo(String meno, String heslo);
    
    void odstranVsetko();
    
}
