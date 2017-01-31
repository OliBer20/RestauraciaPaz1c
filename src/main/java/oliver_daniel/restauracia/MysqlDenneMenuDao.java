package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import oliver_daniel.restauracia.DenneMenuDao;
import oliver_daniel.restauracia.MysqlJedlaDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import oliver_daniel.restauracia.JedloDao;

public class MysqlDenneMenuDao implements DenneMenuDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDenneMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Long> ziskajDenneMenu() {
        String sql = "select * from denne_menu";
        return jdbcTemplate.query(sql, new MysqlDenneMenuDao.DMenuRowMapper());

    }

    @Override
    public void pridaj(Long id) {
        try {
            jdbcTemplate.update("insert into denne_menu (id) values (?)", id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nedá sa pridat 2x to isté jedlo!");
        }
    }

    @Override
    public void odober(Long id) {
        jdbcTemplate.update("delete from denne_menu where id = ?", id);
    }

    @Override
    public void vymazVsetko() {
        jdbcTemplate.update("truncate denne_menu");
    }

    private class DMenuRowMapper implements RowMapper<Long> {

        @Override
        public Long mapRow(ResultSet rs, int i) throws SQLException {
            return rs.getLong("id");
        }

    }

}
