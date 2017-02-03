package dao;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes;
import entity.Objednavka;
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

public class MysqlVypisDao implements vypisDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlVypisDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Objednavka> dajVsetkyObjednavky() {
        String sql = "select * from objednavka order by id_objednavky desc";
        return jdbcTemplate.query(sql, new MysqlVypisDao.VypisRowMapper());
    }

    @Override
    public List<Objednavka> dajDnesneObjednavky() {
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) + 1;
        int rok = cal.get(Calendar.YEAR);
        String sql = "select * from objednavka where dayofmonth(datum) = " + den + " and month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id_objednavky desc";
        return jdbcTemplate.query(sql, new MysqlVypisDao.VypisRowMapper());

    }


    @Override
    public List<Objednavka> dajPodlaMesiaca(int rok, int mesiac) {
        String sql = "select * from objednavka where month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id_objednavky desc";
        return jdbcTemplate.query(sql, new MysqlVypisDao.VypisRowMapper());

    }

    @Override
    public List<Objednavka> dajPodlaRoka(int rok) {
        String sql = "select * from objednavka where year(datum) = " + rok + " order by id_objednavky desc";
        return jdbcTemplate.query(sql, new MysqlVypisDao.VypisRowMapper());

    }

    @Override
    public List<Objednavka> dajPodlaDatumu(int rok, int mesiac, int den) {
        String sql = "select * from objednavka where dayofmonth(datum) = " + den + " and month(datum) = " + mesiac + " and year(datum) = " + rok + " order by id_objednavky desc";
        return jdbcTemplate.query(sql, new MysqlVypisDao.VypisRowMapper());

    }

    private class VypisRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka o = new Objednavka();
            o.setId(rs.getLong("id_objednavky"));
            o.setPopis(rs.getString("popis"));
            o.setSuma(rs.getDouble("suma"));
            o.setCasObjednavky(rs.getDate("datum"));
            return o;
        }

    }

}
