package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlUzivatelDao implements UzivatelDao {

    private JdbcTemplate jdbcTemplate;

    public MysqlUzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void odstranVsetko() {
        jdbcTemplate.update("truncate hesla");

    }

    @Override
    public uzivatel dajHeslo(String meno) {
        String sql = "select heslo from hesla where meno = ?";
        BeanPropertyRowMapper<uzivatel> mapper = BeanPropertyRowMapper.newInstance(uzivatel.class);
        return jdbcTemplate.queryForObject(sql, mapper, meno);
         
    }

    @Override
    public void nastavHeslo(String meno, String heslo) {
        jdbcTemplate.update("update hesla set heslo = ? where meno = ?",
               heslo, meno);
        
        }
    
}
