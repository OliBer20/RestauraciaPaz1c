package oliver_daniel.restauracia;

import java.util.List;

public interface DenneMenuDao {

    void pridaj(Long id);

    void odober(Long id);

    void vymazVsetko();

    List<Long> ziskajDenneMenu();

}
