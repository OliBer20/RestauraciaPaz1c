package oliver_daniel.restauracia;

import java.util.List;
import oliver_daniel.restauracia.Napoj;

public interface NapojeDao {

    void pridajNapoj(Napoj n);

    List<Napoj> dajNapoje();

    void vymazNapoj(Napoj n);

    Long dajIDPodlaNazvu(String nazov);

    void vymazVsetkyNapoje();

    double ziskajCenu(Napoj n);

}
