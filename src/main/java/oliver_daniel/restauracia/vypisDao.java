package oliver_daniel.restauracia;

import java.util.Date;
import java.util.List;

interface vypisDao {

    void pridajObjednavku(Objednavka o);

    void vymazVsetkyJedla();

    List<Objednavka> dajVsetkyObjednavky();

    void Odstran(Objednavka objednavka);

    List<Objednavka> dajDnesneObjednavky();

    public List<Objednavka> dajPodlaMesiaca(int rok, int mesiac);
    
    public List<Objednavka> dajPodlaRoka(int rok);

    List<Objednavka> dajPodlaDatumu(int rok, int mesiac, int den);

    List<Objednavka> dajMesacneObjednavky();

}
