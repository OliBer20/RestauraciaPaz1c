package dao;

import entity.Kategoria;
import dao.KategoriaDao;
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
        jdbcTemplate.update("INSERT INTO Kategoria (nazov) VALUES(?)",kategoria.getNazov());
    }

    public Kategoria dajKategoriu(Long id) {
        String sql = "SELECT id_kat, nazov FROM Kategoria WHERE id_kat = ?";
        return jdbcTemplate.queryForObject(sql, new MysqlKategoriaDao.KategoriaRowMapper(),id);
    }
    
    public Kategoria dajKategoriu(String nazov) {
        String sql = "SELECT id_kat, nazov FROM Kategoria WHERE nazov = ?";
        return jdbcTemplate.queryForObject(sql, new MysqlKategoriaDao.KategoriaRowMapper(),nazov);
    }
    
    public List<Kategoria> dajVsetkyKategorie() {
        String sql = "SELECT id_kat,nazov FROM Kategoria";
        return jdbcTemplate.query(sql, new MysqlKategoriaDao.KategoriaRowMapper());
    }

  
   

    private class KategoriaRowMapper implements RowMapper<Kategoria> {

        @Override
        public Kategoria mapRow(ResultSet rs, int i) throws SQLException {
            Kategoria k = new Kategoria();
            k.setId(rs.getLong("id_kat"));
            k.setNazov(rs.getString("nazov"));
            return k;
        }

    }

}
