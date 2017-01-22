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

public class MysqlCenyJedalDao implements jedloSCenouDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlCenyJedalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void pridajJedlo(jedloSCenou j) {
        try {
            jdbcTemplate.update("INSERT INTO ceny_jedal (id, nazov, cena) VALUES(?,?,?)", null,
                    j.getJedlo(), j.getCena());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, j.getJedlo() + " sa uz nachadza v Databaze cien!!");
        }

    }

    @Override
    public void vymazJedlo(jedloSCenou j) {
        jdbcTemplate.update("delete from ceny_jedal where nazov = ?",
                j.getJedlo());
    }

    @Override
    public void vymazVsetkyJedla() {
        jdbcTemplate.update("truncate ceny_jedal");
    }

    public List<jedloSCenou> dajJedlaSCenami() {
        String sql = "select * from ceny_jedal";
        return jdbcTemplate.query(sql, new cenyJedalRowMapper());
    }

    @Override
    public double ziskajCenu(jedloSCenou j) {
        double d = 0;
        List<jedloSCenou> jedla = dajJedlaSCenami();
        for (jedloSCenou jedlo : jedla) {
            if (jedlo.getJedlo().equals(j.getJedlo())) {
                return jedlo.getCena();
            }
        }
        return -1;
    }


    private class cenyJedalRowMapper implements RowMapper<jedloSCenou> {

        @Override
        public jedloSCenou mapRow(ResultSet rs, int i) throws SQLException {
            jedloSCenou j = new jedloSCenou();
            j.setId(rs.getLong("id"));
            j.setJedlo(rs.getString("nazov"));
            j.setCena(rs.getDouble("cena"));
            return j;
        }

    }

}
