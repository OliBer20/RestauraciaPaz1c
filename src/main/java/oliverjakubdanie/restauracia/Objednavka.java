package oliverjakubdanie.restauracia;

import java.util.Date;

public class Objednavka {

    private String nazovJedla;
    private double cenaJedla;
    private Date casObjednavky;

    public Date getCasObjednavky() {
        return casObjednavky;
    }

    public double getCenaJedla() {
        return cenaJedla;
    }

    public String getNazovJedla() {
        return nazovJedla;
    }

    public void setCasObjednavky(Date casObjednavky) {
        this.casObjednavky = casObjednavky;
    }

    public void setCenaJedla(double cenaJedla) {
        this.cenaJedla = cenaJedla;
    }

    public void setNazovJedla(String nazovJedla) {
        this.nazovJedla = nazovJedla;
    }


}
