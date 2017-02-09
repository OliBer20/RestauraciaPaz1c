package dao;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlUserDao {

    public MysqlDataSource dataSource;

    public MysqlUserDao() {
        dataSource = new MysqlDataSource();
        dataSource.setUser("restauraciaUser");
        dataSource.setPassword("restauraciauser");

    }

}
