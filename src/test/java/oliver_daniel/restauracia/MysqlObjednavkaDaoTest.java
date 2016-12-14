/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliver_daniel.restauracia;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class MysqlObjednavkaDaoTest {

    private MysqlObjednavkaDao test = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private Objednavka testobjednavka = new Objednavka();

    public MysqlObjednavkaDaoTest() {
        testobjednavka.setId(0);
        testobjednavka.setNazovJedla("testjedlo");
        testobjednavka.setCenaJedla(3);
        testobjednavka.setCasObjednavky(new Date(2016 - 1900, Calendar.JANUARY, 1));
    }

    @Test
    public void testDajObjednavky() {
        test.odstranVsetko();
        List<Objednavka> objednavka = test.dajObjednavky();
        Assert.assertEquals(0, objednavka.size());
    }

    @Test
    public void testPridaj() {
        List<Objednavka> objednavky = test.dajObjednavky();
        test.odstranVsetko();
        test.pridaj(testobjednavka);
        List<Objednavka> objednavkypo = test.dajObjednavky();
        Assert.assertEquals(objednavkypo.size(), objednavky.size() + 1);

    }

    @Test
    public void testOdstran() {
        test.odstranVsetko();
        test.pridaj(testobjednavka);
        List<Objednavka> objednavka = test.dajObjednavky();
        test.Odstran(testobjednavka);
        List<Objednavka> objednavka2 = test.dajObjednavky();
       
        Assert.assertEquals(objednavka.size(), objednavka2.size());

    }

    @Test
    public void testOdstranVsetko() {
        test.odstranVsetko();
        List<Objednavka> objednavky = test.dajObjednavky();
        
        Assert.assertEquals(0, objednavky.size());
    }
    @Test
    public void testvymazPredosluObjednavku() {
        test.odstranVsetko();
        test.pridaj(testobjednavka);
        List<Objednavka> objednavkypred = test.dajObjednavky();
        test.vymazPredosluObjednavku();
        List<Objednavka> objednavky = test.dajObjednavky();
        
        Assert.assertEquals(objednavkypred.size(),objednavky.size() + 1);
    }
}
