package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import oliver_daniel.restauracia.DenneMenu;
import oliver_daniel.restauracia.DenneMenuDao;
import oliver_daniel.restauracia.MysqlCenyJedalDao;
import oliver_daniel.restauracia.jedloSCenou;
import oliver_daniel.restauracia.jedloSCenouDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlVsetkyJedlaDao implements VsetkyJedlaDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlVsetkyJedlaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> ziskajVsetkyJedla() {
        String sql = "select jedlo from vsetky_jedla";
        return jdbcTemplate.query(sql, new MysqlVsetkyJedlaDao.VsetkyJedlaMapper());

    }

    @Override
    public void pridaj(String s) {
        try {
            jdbcTemplate.update("insert into vsetky_jedla (id,jedlo) values (?,?)", null,
                    s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uz sa nachadza medzi jedlami!");
        }
    }

    @Override
    public void odober(String s) {
        jdbcTemplate.update("delete from vsetky_jedla where jedlo = ? limit 1", s);
    }

    @Override
    public void vymazVsetko() {
        jdbcTemplate.update("truncate vsetky_jedla");
    }

    private class VsetkyJedlaMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("jedlo");

        }

    }

}
