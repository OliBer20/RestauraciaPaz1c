package oliver_daniel.restauracia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu implements MenuDao {


    private List<String> menu = new ArrayList<>();

    @Override
    public List<String> getMenu() {
        return menu;
    }

    @Override
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    @Override
    public void pridajJedlo(String nazov) {
              
        menu.add(nazov);

    }

}
