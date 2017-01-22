package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlPridajNapojDao implements NapojeDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlPridajNapojDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Napoj> dajNapoje() {

        String sql = "SELECT * FROM napoje order by id desc";
        return jdbcTemplate.query(sql, new NapojeRowMapper());

    }

    @Override
    public void pridajNapoj(Napoj napoj) {
        try {
            jdbcTemplate.update("INSERT INTO napoje (id, napoj, cena) VALUES(?,?,?)", null,
                    napoj.getNapoj(), napoj.getCena());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uz je pridany napoj s rovnakym menom!!");
        }

    }

    @Override
    public void vymazVsetkyNapoje() {
        jdbcTemplate.update("truncate napoje");
    }

    @Override
    public void vymazNapoj(Napoj napoj) {
        jdbcTemplate.update("delete from napoje where napoj = ?", napoj.getNapoj());

    }

    @Override
    public double ziskajCenu(Napoj n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class NapojeRowMapper implements RowMapper<Napoj> {

        @Override
        public Napoj mapRow(ResultSet rs, int i) throws SQLException {
            Napoj n = new Napoj();
            Long id = (rs.getLong("id"));
            String s = (rs.getString("napoj"));
            double cena = (rs.getDouble("cena"));
            n.setCena(cena);
            n.setNapoj(s);
            return n;
        }

    }
}
