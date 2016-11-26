
package oliverjakubdanie.restauracia;

import java.util.List;

public interface MenuDao {

    List<String> getMenu();

    void pridajJedlo(String nazov);

    void setMenu(List<String> menu);
    
}
