package oliverjakubdanie.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlObjednavkaDao implements ObjednavkyDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlObjednavkaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Objednavka> dajObjednavky() {
        String sql = "SELECT id,jedlo,cena,datum "
                    + "FROM objednavky_table";
        return jdbcTemplate.query(sql, new ObjednavkaRowMapper());
    }

    @Override
    public void pridaj(Objednavka objednavka) {
        jdbcTemplate.update("INSERT INTO objednavky_table (id, jedlo, cena, datum) VALUES(?,?,?,?)",null,
                objednavka.getNazovJedla(), objednavka.getCenaJedla(), null);
    }

  
    private class ObjednavkaRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka objednavka = new Objednavka();
            objednavka.setId(rs.getInt("id"));
            objednavka.setNazovJedla(rs.getString("jedlo"));
            objednavka.setCenaJedla(rs.getDouble("cena"));
            objednavka.setCasObjednavky(rs.getDate("datum"));
            return objednavka;
        }
        
    }
}
