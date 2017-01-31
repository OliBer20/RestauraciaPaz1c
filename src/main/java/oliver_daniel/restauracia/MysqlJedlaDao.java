package oliver_daniel.restauracia;

import oliver_daniel.restauracia.Jedlo;
import oliver_daniel.restauracia.JedloDao;
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

public class MysqlJedlaDao implements JedloDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlJedlaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridajJedlo(Jedlo j) {
        try {
            jdbcTemplate.update("INSERT INTO jedla (id, nazov, cena) VALUES(?,?,?)", null,
                    j.getNazov(), j.getCena());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, j.getNazov() + " sa uz nachadza v Databaze cien!!");
        }

    }
    
     @Override
    public Jedlo vratPodlaId(Long id) {
        List<Jedlo> jedla = dajJedla();
        for (Jedlo jedlo : jedla) {
            if(jedlo.getId() == id)
                return jedlo;
        }
        return null;
    }

    @Override
    public void vymazJedlo(Jedlo j) {
        jdbcTemplate.update("delete from jedla where nazov = ?",
                j.getNazov());
    }

    @Override
    public void vymazVsetkyJedla() {
        jdbcTemplate.update("truncate jedla");
    }

    public List<Jedlo> dajJedla() {
        String sql = "select * from jedla";
        return jdbcTemplate.query(sql, new cenyJedalRowMapper());
    }

    @Override
    public double ziskajCenu(Jedlo j) {
        double d = 0;
        List<Jedlo> jedla = dajJedla();
        for (Jedlo jedlo : jedla) {
            if (jedlo.getNazov().equals(j.getNazov())) {
                return jedlo.getCena();
            }
        }
        return -1;
    }


    private class cenyJedalRowMapper implements RowMapper<Jedlo> {

        @Override
        public Jedlo mapRow(ResultSet rs, int i) throws SQLException {
            Jedlo j = new Jedlo();
            j.setId(rs.getLong("id"));
            j.setNazov(rs.getString("nazov"));
            j.setCena(rs.getDouble("cena"));
            return j;
        }

    }

}
