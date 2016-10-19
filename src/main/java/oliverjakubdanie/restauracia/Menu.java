package oliverjakubdanie.restauracia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menu {

    public Menu() {
        JednaPolozkaMenu jedlo1 = new JednaPolozkaMenu();
        jedlo1.setNazov("Grilovany Encian na smotane");
        jedlo1.setCena(5.05);
        menu.add(jedlo1);

        JednaPolozkaMenu jedlo2 = new JednaPolozkaMenu();
        jedlo2.setNazov("Zapekane zemiaky so salatom");
        jedlo2.setCena(3.50);
        menu.add(jedlo2);
    }

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
        o.setCena(cena);
        menu.add(o);

    }

}
