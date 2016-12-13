package oliver_daniel.restauracia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MysqlPridajNapojDao implements NapojeDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public MysqlPridajNapojDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<String> dajNapoje() {
        
        String sql = "SELECT napoj FROM napoje order by id desc";
        return jdbcTemplate.query(sql, new NapojeRowMapper());
        
    }
    
    @Override
    public void pridajNapoj(String napoj) {
        try {
            jdbcTemplate.update("INSERT INTO napoje (id, napoj) VALUES(?,?)", null,
                    napoj);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Uz je pridany napoj s rovnakym menom!!");
        }
        
    }
    
    @Override
    public void vymazVsetkyNapoje() {
        jdbcTemplate.update("truncate napoje");
    }
    
    @Override
    public void vymazNapoj(String napoj) {
        jdbcTemplate.update("delete from napoje where napoj = ?", napoj);
        
    }
    
    private class NapojeRowMapper implements RowMapper<String> {
        
        @Override
        public String mapRow(ResultSet rs, int i) throws SQLException {
            String s = (rs.getString("napoj"));
            return s;
        }
        
    }
}
