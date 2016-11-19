package oliverjakubdanie.restauracia;

public class JednaPolozkaMenu {

    private String nazov;
    private double cena;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public double getCena() {
        return cena;
    }

    public String getNazov() {
        return nazov;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

}
