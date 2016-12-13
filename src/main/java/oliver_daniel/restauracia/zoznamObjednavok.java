package oliver_daniel.restauracia;

import java.util.ArrayList;
import java.util.List;

public class zoznamObjednavok implements ObjednavkyDao {

    private List<Objednavka> objednavky = new ArrayList<>();

    @Override
    public List<Objednavka> dajObjednavky() {
        return objednavky;
    }

    @Override
    public void pridaj(Objednavka o) {
        Objednavka oo = new Objednavka();
        oo.setId(o.getId());
        oo.setNazovJedla(o.getNazovJedla());
        oo.setCenaJedla(o.getCenaJedla());
        oo.setCasObjednavky(o.getCasObjednavky());

        objednavky.add(o);
    }

    

    @Override
    public void odstranVsetko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void Odstran(Objednavka objednavka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazPredosluObjednavku() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
