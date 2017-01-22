package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlCenyNapojovDao implements NapojeDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlCenyNapojovDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
     @Override
    public void pridajNapoj(Napoj n) {
        try {
            jdbcTemplate.update("INSERT INTO ceny_napojov (id, nazov, cena) VALUES(?,?,?)", null,
                    n.getNapoj(), n.getCena());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Napoj:" + n.getNapoj() + " sa uz nachadza v Databaze cien!!");
        }

    }

    public List<Napoj> dajCenyNapojov() {
        String sql = "select * from ceny_napojov";
        return jdbcTemplate.query(sql, new CenyRowMapper());
    }

    @Override
    public double ziskajCenu(Napoj n) {
        double d = 0;
        List<Napoj> napoje = dajCenyNapojov();
        for (Napoj napoj : napoje) {
            if (napoj.getNapoj().equals(n.getNapoj())) {
                return napoj.getCena();
            }
        }
        return -1;
    }

    @Override
    public void vymazNapoj(Napoj n) {
         jdbcTemplate.update("delete from ceny_napojov where nazov = ?",
               n.getNapoj());
    }

    @Override
    public void vymazVsetkyNapoje() {
         jdbcTemplate.update("truncate ceny_napojov");
    }

    @Override
    public List<Napoj> dajNapoje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class CenyRowMapper implements RowMapper<Napoj> {

        @Override
        public Napoj mapRow(ResultSet rs, int i) throws SQLException {
            Napoj n = new Napoj();
            n.setId(rs.getLong("id"));
            n.setNapoj(rs.getString("nazov"));
            n.setCena(rs.getDouble("cena"));
            return n;
        }

    }

}
