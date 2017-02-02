package oliver_daniel.restauracia;

import oliver_daniel.restauracia.MysqlDenneMenuDao;
import oliver_daniel.restauracia.MysqlVypisDao;
import oliver_daniel.restauracia.MysqlObjednavkaDao;
import oliver_daniel.restauracia.vypisDao;
import oliver_daniel.restauracia.ObjednavkyDao;
import oliver_daniel.restauracia.DenneMenuDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactoryTest {
    INSTANCE;

    private JdbcTemplate jdbcTemplate;

    public ObjednavkyDao getObjednavkaDao() {
        return new MysqlObjednavkaDao(getJdbcTemplate());
    }

    public vypisDao getVypis() {
        return new MysqlVypisDao(getJdbcTemplate());
    }



    public DenneMenuDao getDenneMenu() {
        return new MysqlDenneMenuDao(getJdbcTemplate());
    }

    public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/objednavky_test?serverTimezone=UTC");
            dataSource.setUser("restauraciaUser");
            dataSource.setPassword("restauracia");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

}
