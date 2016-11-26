package oliverjakubdanie.restauracia;

import java.util.Map;

public interface jedloSCenouDao {

    void pridajJedlo(jedloSCenou j);

    void vymazJedlo(jedloSCenou j);

    void vymazVsetkyJedla();

    double ziskajCenu(jedloSCenou j);

}
