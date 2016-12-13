package oliver_daniel.restauracia;

import java.util.ArrayList;
import java.util.List;

public class DenneMenu implements DenneMenuDao {

    private List<String> zoznamDennehoMenu = new ArrayList<>();
    private String nazov;

    @Override
    public String getNazov() {
        return nazov;
    }

    @Override
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public List<String> ziskajDenneMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void odober(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pridaj(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vymazVsetko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
