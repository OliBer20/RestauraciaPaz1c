package oliverjakubdanie.restauracia;

import java.util.List;
 
public interface VsetkyJedlaDao {
   
    void pridaj(String s);
    
    void odober(String s);
    
    void vymazVsetko();
    
    List<String> ziskajVsetkyJedla();

    
}
