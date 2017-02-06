package dao;

import entity.Kategoria;
import entity.Polozka;
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

public class MysqlDenneMenuDao implements DenneMenuDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlDenneMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Polozka> ziskajDenneMenu() {
        String sql = "select P.nazov nazov from dennemenu D join polozka \n"
                + "P on P.id_polozky = D.id_polozky";
        return jdbcTemplate.query(sql, new MysqlDenneMenuDao.DMenuRowMapper());

    }

    @Override
    public void pridaj(Long id_polozky) {
        try {
            jdbcTemplate.update("insert into dennemenu (id_polozky) values (?)", id_polozky);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void odober(Polozka p) {
        System.out.println(Long.toString(p.getId()));
        jdbcTemplate.update("delete from dennemenu where id = ?", p.getId());
    }

    @Override
    public void vymazVsetko() {
        jdbcTemplate.update("truncate dennemenu");
    }

    private class DMenuRowMapper implements RowMapper<Polozka> {

        @Override
        public Polozka mapRow(ResultSet rs, int i) throws SQLException {
            Polozka p = new Polozka();
            p.setNazov(rs.getString("nazov"));
            return p;
        }

    }

}
