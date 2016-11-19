
package oliverjakubdanie.restauracia;

import java.util.Map;

public interface NewInterface {

    void aktualizujTxt(Map<String, Double> m);

    double getCena();

    String getJedlo();

    void naplnMapuJedlamiZTxt();

    void pridajJedlo(String jedlo, double cena);

    void vymazJedlo(String jedlo, double cena);

    void vymazVsetkyJedla();

    void zapisJedlo(String jedlo, double cena);

    double ziskajCenu(String jedlo);

    void zmenCenu(String jedlo, double NovaCena);
    
}
