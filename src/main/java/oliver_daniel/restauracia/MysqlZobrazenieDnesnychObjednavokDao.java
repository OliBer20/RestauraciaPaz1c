package oliver_daniel.restauracia;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
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

public class MysqlZobrazenieDnesnychObjednavokDao implements zobrazenieDnesnychObjednavokDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlZobrazenieDnesnychObjednavokDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Objednavka> dajDnesneObjednavky() {
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) + 1;
        int rok = cal.get(Calendar.YEAR);
        String sql = "select * from objednavky_table where dayofmonth(datum) = " + den + " and month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id desc";
        return jdbcTemplate.query(sql, new MysqlZobrazenieDnesnychObjednavokDao.zobrazenieDnesnychObjednavokRowMapper());

    }

    private class zobrazenieDnesnychObjednavokRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka o = new Objednavka();
            o.setNazov(rs.getString("nazov"));
            o.setCena(rs.getDouble("cena"));
            o.setCasObjednavky(rs.getDate("datum"));
            return o;
        }

    }

}
