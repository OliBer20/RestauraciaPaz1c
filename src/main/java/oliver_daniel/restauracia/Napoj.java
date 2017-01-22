package oliver_daniel.restauracia;

public class Napoj {

    private Long id;
    private String nazov;
    private double cena;

    public double getCena() {
        return cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

}
