 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliver_daniel.restauracia;

import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlVsetkyJedlaDaoTest {
    private   MysqlVsetkyJedlaDao test = new MysqlVsetkyJedlaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());

    public MysqlVsetkyJedlaDaoTest() {
        
        
                }

    @Test
    public void testZiskajVsetkyJedla() {
        test.vymazVsetko();
        List<String> vsetky =test.ziskajVsetkyJedla();
        Assert.assertEquals(0,vsetky.size() );
    }

    @Test
    public void testPridaj() {
                test.vymazVsetko();
                List<String> vsetkypred = test.ziskajVsetkyJedla();
                test.pridaj("Jedlo");
                List<String> vsetkypo = test.ziskajVsetkyJedla();
                Assert.assertEquals(vsetkypred.size()+1,vsetkypo.size());
    }

    @Test
    public void testOdober() {
                test.vymazVsetko();
                test.pridaj("Jedlo");
                List<String> vsetky= test.ziskajVsetkyJedla();
                test.odober("Jedlo");
                List<String> vsetkypo = test.ziskajVsetkyJedla();
                Assert.assertEquals(vsetky.size(),vsetkypo.size()+1);
                
                
    }

    @Test
    public void testVymazVsetko() {
                test.vymazVsetko();
                List<String> vsetkypo = test.ziskajVsetkyJedla();
                Assert.assertEquals(0,vsetkypo.size());
                

    }
    
}
