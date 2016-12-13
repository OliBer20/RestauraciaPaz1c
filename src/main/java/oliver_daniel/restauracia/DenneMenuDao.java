package oliver_daniel.restauracia;

import java.util.List;
 
public interface DenneMenuDao {

    String getNazov();
    
    void pridaj(String s);
    
    void odober(String s);
    
    void setNazov(String nazov);
    
    void vymazVsetko();
    
    List<String> ziskajDenneMenu();

    
}
