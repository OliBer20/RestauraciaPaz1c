package oliverjakubdanie.restauracia;

import java.util.ArrayList;
import java.util.List;

public class zoznamObjednavok {

    private List<Objednavka> objednavky = new ArrayList<>();

    public List<Objednavka> getObjednavky() {
        return objednavky;
    }

    public zoznamObjednavok() {

    }

    public void pridajObjednavku(Objednavka o) {
        Objednavka oo = new Objednavka();
        oo.setId(o.getId());
        oo.setNazovJedla(o.getNazovJedla());
        oo.setCenaJedla(o.getCenaJedla());
        oo.setCasObjednavky(o.getCasObjednavky());
        
        objednavky.add(o);

    }

    public List<Objednavka> vypisVsetkyObjednavky() {
        return objednavky;
    }

}
