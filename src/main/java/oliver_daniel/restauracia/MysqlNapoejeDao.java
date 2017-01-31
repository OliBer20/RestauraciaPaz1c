package oliver_daniel.restauracia;

import oliver_daniel.restauracia.Napoj;
import oliver_daniel.restauracia.NapojeDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlNapoejeDao implements NapojeDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlNapoejeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Napoj> dajNapoje() {

        String sql = "SELECT * FROM napoje order by id desc";
        return jdbcTemplate.query(sql, new NapojeRowMapper());

    }

    @Override
    public double ziskajCenu(Napoj n) {
        List<Napoj> napoje = dajNapoje();
        for (Napoj napoj : napoje) {
            if (napoj.getNazov().equals(n.getNazov())) {
                return napoj.getCena();
            }
        }
        return -1;
    }

    @Override
    public void pridajNapoj(Napoj napoj) {
        try {
            jdbcTemplate.update("INSERT INTO napoje (id, nazov, cena) VALUES(?,?,?)", null,
                    napoj.getNazov(), napoj.getCena());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Napoj:" + napoj.getNazov() + " sa uz nachadza v Databaze cien!!");
        }

    }

    @Override
    public void vymazVsetkyNapoje() {
        jdbcTemplate.update("truncate napoje");
    }

    @Override
    public Long dajIDPodlaNazvu(String nazov) {
        List<Napoj> napoje = dajNapoje();
        for (Napoj napoj : napoje) {
            if (napoj.getNazov().equals(nazov)) {
                return napoj.getId();
            }
        }
        return null;

    }

    @Override
    public void vymazNapoj(Napoj napoj) {
        jdbcTemplate.update("delete from napoje where nazov = ?", napoj.getNazov());

    }

    private class NapojeRowMapper implements RowMapper<Napoj> {

        @Override
        public Napoj mapRow(ResultSet rs, int i) throws SQLException {
            Napoj n = new Napoj();
            Long id = (rs.getLong("id"));
            String s = (rs.getString("nazov"));
            double cena = (rs.getDouble("cena"));
            n.setCena(cena);
            n.setNazov(s);
            return n;
        }

    }
}
