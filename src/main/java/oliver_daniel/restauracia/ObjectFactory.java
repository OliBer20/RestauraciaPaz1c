package oliver_daniel.restauracia;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum ObjectFactory {
    INSTANCE;

    private JdbcTemplate jdbcTemplate;
    
    public NapojeDao getCenyNapojovDao(){
        return new MysqlCenyNapojovDao(getJdbcTemplate());
    }

    public ObjednavkyDao getObjednavkaDao() {
        return new MysqlObjednavkaDao(getJdbcTemplate());
    }

    public zobrazenieDnesnychObjednavokDao getDnesneObjednavky() {
        return new MysqlZobrazenieDnesnychObjednavokDao(getJdbcTemplate());
    }

    public vypisDao getVypis() {
        return new MysqlVypisDao(getJdbcTemplate());
    }

    public jedloSCenouDao getCenyDao() {
        return new MysqlCenyJedalDao(getJdbcTemplate());
    }

    public VsetkyJedlaDao getMenu() {
        return new MysqlVsetkyJedlaDao(getJdbcTemplate());
    }

    public DenneMenuDao getDenneMenu() {
        return new MysqlDenneMenuDao(getJdbcTemplate());
    }

    public NapojeDao getNapoje() {
        return new MysqlPridajNapojDao(getJdbcTemplate());
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
