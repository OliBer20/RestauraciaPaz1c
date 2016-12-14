/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  oliver_daniel.restauracia;

import oliver_daniel.restauracia.ObjectFactoryTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlDenneMenuDaoTest {
    private  MysqlDenneMenuDao test = new MysqlDenneMenuDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    public MysqlDenneMenuDaoTest() {
    }

    @Test
    public void testGetNazov() {
     
    }

    @Test
    public void testSetNazov() {
    }

    @Test
    public void testZiskajDenneMenu() {
           test.vymazVsetko();
           List<String> jedlalist = test.ziskajDenneMenu();
           Assert.assertEquals(0, jedlalist.size());         
    }

    @Test
    public void testPridaj() {
       test.vymazVsetko();
       List<String> pred = test.ziskajDenneMenu();
       test.pridaj("salat");
       List<String> po = test.ziskajDenneMenu();
       Assert.assertEquals(pred.size()+1, po.size());           
    }
    @Test
    public void testOdober() {
       test.vymazVsetko();
       test.pridaj("salat");
       List<String> pred = test.ziskajDenneMenu();
       test.odober("salat");
       List<String> po = test.ziskajDenneMenu();
       Assert.assertEquals(pred.size()-1 ,po.size());         
    }
    @Test
    public void testVymazVsetko() {
        test.vymazVsetko();
        List<String> dennemenu = test.ziskajDenneMenu();           
       Assert.assertEquals(0,dennemenu.size());
    }  
}
