package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        String sql = "SELECT id,nazov,cena,datum "
                + "FROM objednavky_table order by id desc";
        return jdbcTemplate.query(sql, new ObjednavkaRowMapper());
    }

    @Override
    public void Odstran(Objednavka objednavka) {
        jdbcTemplate.update("delete from objednavky_table where id = ?",
                objednavka.getId());
    }

    @Override
    public void pridaj(Objednavka objednavka) {
        Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR) - 1900;
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH) + 1;
        Date datum = new Date(year, month, day);
        jdbcTemplate.update("INSERT INTO objednavky_table (id, nazov, cena, datum) VALUES(?,?,?,?)", null,
                objednavka.getNazov(), objednavka.getCena(), datum);
    }

    @Override
    public void odstranVsetko() {
        jdbcTemplate.update("truncate objednavky_table");

    }

    @Override
    public void vymazPredosluObjednavku() {
        jdbcTemplate.update("delete from objednavky_table where nazov is not null order by id desc limit 1");
    }

    private class ObjednavkaRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka objednavka = new Objednavka();
            objednavka.setId(rs.getLong("id"));
            objednavka.setNazov(rs.getString("nazov"));
            objednavka.setCena(rs.getDouble("cena"));
            objednavka.setCasObjednavky(rs.getDate("datum"));
            return objednavka;
        }

    }
}
