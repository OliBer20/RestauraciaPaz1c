
package dao;

import entity.Kategoria;
import java.util.List;


public interface KategoriaDao {
    
    void pridajKategoriu(Kategoria kategoria);
    
    void vymazKategoriu(Kategoria kategoria);
    
    public Kategoria dajKategoriu(Long id);
     
    public Kategoria dajKategoriu(String nazov);
    
    public List<Kategoria> dajVsetkyKategorie();
    
}
