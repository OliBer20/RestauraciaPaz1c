package oliver_daniel.restauracia;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlUserDao {
    
    private MysqlDataSource dataSource;
    
   public MysqlUserDao(){
      dataSource = new MysqlDataSource();
      dataSource.setUser("restauraciaUser");
      dataSource.setPassword("restauraciauser");
       
       
   } 
    
}
