package oliver_daniel.restauracia;


import oliver_daniel.restauracia.MysqlDenneMenuDao;
import oliver_daniel.restauracia.MysqlVypisDao;
import oliver_daniel.restauracia.MysqlUzivatelDao;
import oliver_daniel.restauracia.MysqlObjednavkaDao;
import oliver_daniel.restauracia.MysqlPolozkaDao;
import oliver_daniel.restauracia.vypisDao;
import oliver_daniel.restauracia.UzivatelDao;
import oliver_daniel.restauracia.ObjednavkyDao;
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

    public DenneMenuDao getDenneMenu() {
        return new MysqlDenneMenuDao(getJdbcTemplate());
    }

    public UzivatelDao getHesla(){
        return new MysqlUzivatelDao(getJdbcTemplate());
    }
    
    public PolozkaDao getPolozky(){
        return new MysqlPolozkaDao(getJdbcTemplate());
    }

    public KategoriaDao getKategorie(){
        return new MysqlKategoriaDao(getJdbcTemplate());
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
