package oliverjakubdanie.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlDenneMenuDao implements DenneMenuDao  {

    private JdbcTemplate jdbcTemplate;

    public MysqlDenneMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<JednaPolozkaMenu> dajJedlaZMenu() {
        String sql = "SELECT id,jedlo,cena"
                + "FROM objednavky_table.denne_menu";
        return jdbcTemplate.query(sql, new JednaPolozkaRowMapper());
    }

    @Override
    public void pridaj(JednaPolozkaMenu polozka) {
        jdbcTemplate.update("INSERT INTO denne_menu (id, jedlo, cena) VALUES(?,?,?)", null,
                polozka.getNazov(), polozka.getCena());
    }

    private class JednaPolozkaRowMapper implements RowMapper<JednaPolozkaMenu> {

        @Override
        public JednaPolozkaMenu mapRow(ResultSet rs, int i) throws SQLException {
            JednaPolozkaMenu j = new JednaPolozkaMenu();
            j.setId(rs.getLong("id"));
            j.setNazov(rs.getString("jedlo"));
            j.setCena(rs.getDouble("cena"));
            return j;
        }

    }
}
