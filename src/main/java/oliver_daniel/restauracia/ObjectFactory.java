package oliver_daniel.restauracia;

import oliver_daniel.restauracia.MysqlJedlaDao;
import oliver_daniel.restauracia.MysqlNapoejeDao;
import oliver_daniel.restauracia.MysqlDenneMenuDao;
import oliver_daniel.restauracia.MysqlVypisDao;
import oliver_daniel.restauracia.MysqlUzivatelDao;
import oliver_daniel.restauracia.MysqlObjednavkaDao;
import oliver_daniel.restauracia.vypisDao;
import oliver_daniel.restauracia.UzivatelDao;
import oliver_daniel.restauracia.ObjednavkyDao;
import oliver_daniel.restauracia.NapojeDao;
import oliver_daniel.restauracia.JedloDao;
import oliver_daniel.restauracia.DenneMenuDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    INSTANCE;

    private JdbcTemplate jdbcTemplate;
    
    public ObjednavkyDao getObjednavkaDao() {
        return new MysqlObjednavkaDao(getJdbcTemplate());
    }

    public vypisDao getVypis() {
        return new MysqlVypisDao(getJdbcTemplate());
    }

    public JedloDao getJedla() {
        return new MysqlJedlaDao(getJdbcTemplate());
    }

    public DenneMenuDao getDenneMenu() {
        return new MysqlDenneMenuDao(getJdbcTemplate());
    }

    public NapojeDao getNapoje() {
        return new MysqlNapoejeDao(getJdbcTemplate());
    }
    
    public UzivatelDao getHesla(){
        return new MysqlUzivatelDao(getJdbcTemplate());
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
