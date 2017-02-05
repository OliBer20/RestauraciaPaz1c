package entity;

import entity.Kategoria;

public class Polozka {

    private Long id;
    private String nazov;
    private Kategoria kategoria;
    private Double cena;

    public Double getCena() {
        return cena;
    }
    
    @Override
    public int hashCode() {
        return  nazov.hashCode();   
    }
    
    @Override
    public boolean equals(Object polozka) {
        if(polozka.getClass() == Polozka.class)
            return nazov.equals(((Polozka)polozka).getNazov());
        return false;
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
