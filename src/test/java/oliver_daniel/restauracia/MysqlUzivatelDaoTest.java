/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package oliver_daniel.restauracia;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class MysqlUzivatelDaoTest {
    MysqlUzivatelDao test = new MysqlUzivatelDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    public MysqlUzivatelDaoTest() {
    }


    

    @Test
    public void testDajHeslo() {
        String s = "boss";
        uzivatel h =test.dajHeslo(s);
        Assert.assertEquals(s, h.getHeslo());
        
        
        
        
    }

    @Test
    public void testNastavHeslo() {
        String heslonazmenu ="otherstest";
        test.nastavHeslo("others", heslonazmenu);
        uzivatel h = test.dajHeslo("others");
        Assert.assertEquals(heslonazmenu, h.getHeslo());
        
    }
    
}
*/