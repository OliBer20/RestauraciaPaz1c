package oliverjakubdanie.restauracia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu {


    private List<JednaPolozkaMenu> menu = new ArrayList<>();

    public List<JednaPolozkaMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<JednaPolozkaMenu> menu) {
        this.menu = menu;
    }

    public void pridajJedlo(String nazov, double cena) {
        JednaPolozkaMenu o = new JednaPolozkaMenu();
        o.setNazov(nazov);        
        menu.add(o);

    }

}
