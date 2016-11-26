package oliverjakubdanie.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import oliverjakubdanie.restauracia.DenneMenu;
import oliverjakubdanie.restauracia.DenneMenuDao;
import oliverjakubdanie.restauracia.MysqlCenyJedalDao;
import oliverjakubdanie.restauracia.jedloSCenou;
import oliverjakubdanie.restauracia.jedloSCenouDao;
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
        String sql = "select jedlo from denne_menu";
        return jdbcTemplate.query(sql, new MysqlDenneMenuDao.DMenuRowMapper());

    }

    @Override
    public void pridaj(String s) {
        try {
            jdbcTemplate.update("insert into denne_menu (id,jedlo) values (?,?)", null,
                    s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uz sa nachadza v dennom menu!");
        }
    }

    @Override
    public void odober(String s) {
        jdbcTemplate.update("delete from denne_menu where jedlo = ? limit 1", s);
    }

    @Override
    public void vymazVsetko() {
         jdbcTemplate.update("truncate denne_menu");
    }

    private class DMenuRowMapper implements RowMapper<String> {

        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            //DenneMenu d = new DenneMenu();
            //d.setNazov(rs.getString("nazov"));
            return rs.getString("jedlo");
        }

    }

}
