
package oliverjakubdanie.restauracia;

import java.util.List;


public interface DenneMenuDao {

    List<JednaPolozkaMenu> dajJedlaZMenu();

    void pridaj(JednaPolozkaMenu polozka);
    
}
