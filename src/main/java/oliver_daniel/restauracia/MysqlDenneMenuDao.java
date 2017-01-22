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

public class MysqlDenneMenuDao implements DenneMenuDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDenneMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getNazov() {
        return null;
    }

    @Override
    public void setNazov(String nazov) {
    }

    @Override
    public List<String> ziskajDenneMenu() {
        String sql = "select nazov from denne_menu";
        return jdbcTemplate.query(sql, new MysqlDenneMenuDao.DMenuRowMapper());

    }

    @Override
    public void pridaj(String s) {
        try {
            jdbcTemplate.update("insert into denne_menu (id,nazov) values (?,?)", null,
                    s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uz sa nachadza v dennom menu!");
        }
    }

    @Override
    public void odober(String s) {
        jdbcTemplate.update("delete from denne_menu where nazov = ? limit 1", s);
    }

    @Override
    public void vymazVsetko() {
        jdbcTemplate.update("truncate denne_menu");
    }

    private class DMenuRowMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getString("nazov");
        }

    }

}
