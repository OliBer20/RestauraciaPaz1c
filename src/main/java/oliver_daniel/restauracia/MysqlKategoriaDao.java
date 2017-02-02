package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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

    public Kategoria dajKategoriuJedlo() {
        String sql = "SELECT id_kat, nazov from Kategoria where nazov = Jedlo";
        return jdbcTemplate.queryForObject(sql, new MysqlKategoriaDao.KategoriaRowMapper());

    }
    
      public Kategoria dajKategoriuNapoj() {
        String sql = "SELECT id_kat, nazov from Kategoria where nazov = Napoj";
        return jdbcTemplate.queryForObject(sql, new MysqlKategoriaDao.KategoriaRowMapper());

    }

    @Override
    public void vymazKategoriu(Kategoria kategoria) {

    }

    private class KategoriaRowMapper implements RowMapper<Kategoria> {

        @Override
        public Kategoria mapRow(ResultSet rs, int i) throws SQLException {
            Kategoria k = new Kategoria();
            k.setId(rs.getLong("id"));
            k.setNazov(rs.getString("nazov"));
            return k;
        }

    }

}
