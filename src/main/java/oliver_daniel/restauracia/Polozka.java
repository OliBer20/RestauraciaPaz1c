package oliver_daniel.restauracia;

public class Polozka {

    private Long id;
    private String nazov;
    private Kategoria kategoria;
    private Double cena;

    public Double getCena() {
        return cena;
    }

    public Long getId() {
        return id;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public String getNazov() {
        return nazov;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

}
