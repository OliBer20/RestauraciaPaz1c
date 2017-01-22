package oliver_daniel.restauracia;

import java.util.Date;

public class Objednavka {

    private String nazov;
    private long id;
    private double cena;
    private Date casObjednavky;

    public Date getCasObjednavky() {
        return casObjednavky;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public double getCena() {
        return cena;
    }

    public String getNazov() {
        return nazov;
    }

    public void setCasObjednavky(Date casObjednavky) {
        this.casObjednavky = casObjednavky;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }


}
