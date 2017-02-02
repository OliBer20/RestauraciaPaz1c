package entity;

import java.util.Date;
import java.util.Map;

public class Objednavka {

    private String popis;
    private long id;
    private double suma;
    private Date casObjednavky;
    private Map<Polozka ,Integer> polozky;

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setCasObjednavky(Date casObjednavky) {
        this.casObjednavky = casObjednavky;
    }

    public String getPopis() {
        return popis;
    }

    public long getId() {
        return id;
    }

    public double getSuma() {
        return suma;
    }

    public Date getCasObjednavky() {
        return casObjednavky;
    }

    public Map<Polozka, Integer> getPolozky() {
        return polozky;
    }

    public void setPolozky(Map<Polozka, Integer> polozky) {
        this.polozky = polozky;
    }
    
    

    
    
    
}
