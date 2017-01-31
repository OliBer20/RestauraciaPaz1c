package oliver_daniel.restauracia;

public class Jedlo {

    private Long id;
    private String nazov;
    private double cena;

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public String getNazov() {
        return nazov;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

}
