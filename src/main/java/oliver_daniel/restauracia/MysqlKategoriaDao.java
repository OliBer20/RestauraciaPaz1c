package oliver_daniel.restauracia;

import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlKategoriaDao implements KategoriaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlKategoriaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridajKategoriu(Kategoria kategoria) {
        jdbcTemplate.update("INSERT INTO Kategoria (nazov) VALUES(?)",
                kategoria.getNazov());
    }

    @Override
    public void vymazKategoriu(Kategoria kategoria) {

    }

}
