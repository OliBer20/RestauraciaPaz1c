package oliver_daniel.restauracia;

import java.util.List;
import java.util.Map;
import oliver_daniel.restauracia.Jedlo;

public interface JedloDao {

    void pridajJedlo(Jedlo j);

    void vymazJedlo(Jedlo j);
    
    List<Jedlo> dajJedla();

    void vymazVsetkyJedla();

    Jedlo vratPodlaId(Long id);
    
    double ziskajCenu(Jedlo j);

}
