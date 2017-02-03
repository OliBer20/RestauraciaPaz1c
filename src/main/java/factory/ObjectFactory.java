package factory;

import dao.MysqlKategoriaDao;
import dao.PolozkaDao;
import dao.vypisDao;
import dao.KategoriaDao;
import dao.MysqlUzivatelDao;
import dao.MysqlObjednavkaDao;
import dao.MysqlPolozkaDao;
import dao.UzivatelDao;
import dao.ObjednavkyDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import dao.MysqlVypisDao;
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

    public UzivatelDao getHesla() {
        return new MysqlUzivatelDao(getJdbcTemplate());
    }

    public PolozkaDao getPolozkaDao() {
        return new MysqlPolozkaDao(getJdbcTemplate());
    }

    public KategoriaDao getKategoriaDao() {
        return new MysqlKategoriaDao(getJdbcTemplate());
    }

    private JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/objednavky?serverTimezone=UTC");
            dataSource.setUser("restauraciaUser");
            dataSource.setPassword("restauraciauser");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

}
