
package oliver_daniel.restauracia;


public interface KategoriaDao {
    
    void pridajKategoriu(Kategoria kategoria);
    
    void vymazKategoriu(Kategoria kategoria);
    
     public Kategoria dajKategoriuJedlo();
     
     public Kategoria dajKategoriuNapoj();
    
    
    
}
