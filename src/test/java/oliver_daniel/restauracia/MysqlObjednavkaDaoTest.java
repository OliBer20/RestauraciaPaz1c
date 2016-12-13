/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  oliver_daniel.restauracia;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlObjednavkaDaoTest {
    

    
    public MysqlObjednavkaDaoTest() {
    }

    @Test
    public void testDajObjednavky() {
        MysqlObjednavkaDao mysqlobjednavkadao = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
        List<Objednavka> objednavka = mysqlobjednavkadao.dajObjednavky();
        
            Assert.assertEquals(2, objednavka.size());     
    }
  @Test
    public void testPridaj() {
        MysqlObjednavkaDao mysqlobjednavkaDao = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
        List<Objednavka> objednavky = mysqlobjednavkaDao.dajObjednavky();
        int pocetobjednavok = objednavky.size();
        Objednavka testobjednavka = new Objednavka();
        testobjednavka.setId(0);
        testobjednavka.setCenaJedla(2.5);
        testobjednavka.setNazovJedla("test");
        testobjednavka.setCasObjednavky(new Date(2016 - 1900, Calendar.JANUARY, 1));
        mysqlobjednavkaDao.pridaj(testobjednavka);
        
        List<Objednavka> objednavky2 = mysqlobjednavkaDao.dajObjednavky();
        int pocetobjednavokpopridani = objednavky2.size();
        
        Assert.assertEquals(pocetobjednavokpopridani,pocetobjednavok+1);
        
    }
    @Test
    public void testOdstran() {
        
    MysqlObjednavkaDao obdao = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
      Objednavka testobjednavka = new Objednavka();
        testobjednavka.setId(0);
        testobjednavka.setCenaJedla(2.5);
        testobjednavka.setNazovJedla("test");
        testobjednavka.setCasObjednavky(new Date(2016 - 1900, Calendar.JANUARY, 1));
                   

          obdao.pridaj(testobjednavka);
          List<Objednavka> objednavka = obdao.dajObjednavky();
          int pocetobjednavok = objednavka.size();
          obdao.Odstran(testobjednavka);
          List<Objednavka> objednavky2 = obdao.dajObjednavky();
          int pocetobjednavok2 = objednavky2.size();
          assertEquals(pocetobjednavok, pocetobjednavok2);
        
    }
    @Test
    public void testOdstranVsetko() {
                MysqlObjednavkaDao mysqlobjednavkaDao = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
                mysqlobjednavkaDao.odstranVsetko();
                List<Objednavka> objednavky = mysqlobjednavkaDao.dajObjednavky();
                int pocetobjednavok = objednavky.size();
                Assert.assertEquals(0,pocetobjednavok);           
    }
     public void testvymazPredosluObjednavku() {
         MysqlObjednavkaDao mysqlobjednavkaDao = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());         
       List<Objednavka> objednavkypred = mysqlobjednavkaDao.dajObjednavky();
         int pocetobjpred = objednavkypred.size();
         mysqlobjednavkaDao.vymazPredosluObjednavku();
         List<Objednavka> objednavky = mysqlobjednavkaDao.dajObjednavky();
         int pocetobj = objednavky.size();
         Assert.assertEquals(pocetobjpred, pocetobj+1);
     }
}
