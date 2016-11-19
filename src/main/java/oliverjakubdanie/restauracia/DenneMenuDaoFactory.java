package oliverjakubdanie.restauracia;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DenneMenuDaoFactory {
    INSTANCE;
     private JdbcTemplate jdbcTemplate;
     
    public DenneMenuDao getPolozky() {
        return new MysqlDenneMenuDao(getJdbcTemplate());
    }
    
    private JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/objednavky?serverTimezone=UTC");
            dataSource.setUser("restauraciaUser");
            dataSource.setPassword("restauracia");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }
}


