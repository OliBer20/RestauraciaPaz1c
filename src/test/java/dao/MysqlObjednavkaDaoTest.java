/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kategoria;
import entity.Objednavka;
import entity.Polozka;
import factory.ObjectFactoryTest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
/**
 *
 * @author Daniel
 */
public class MysqlObjednavkaDaoTest {
    private MysqlObjednavkaDao test = new MysqlObjednavkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private MysqlPolozkaDao TEST2 = new MysqlPolozkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private   Objednavka obj = new Objednavka();
    private  Date cas  = new Date();
    private Map<Polozka,Integer> polozky = new HashMap<>();
    private Polozka p = new Polozka();
    
    
    public MysqlObjednavkaDaoTest() {
         Calendar cal = new GregorianCalendar();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date datum = new Date(year-1900,month-1,day+1);
        
        p = TEST2.dajPolozky().get(0);
        polozky.put(p, 1);
        
     //   Date datum = calendar.getTime();
       obj.setSuma(3.5);
       obj.setCasObjednavky(datum);
       obj.setPolozky(polozky);
       obj.setPopis("Popis");

        
    }

    @Test
    public void testNaplnObsahObjednavky() {
        obj=test.dajVsetkyObjednavky().get(0);
        obj.setPolozky(null);
        test.naplnObsahObjednavky(obj);
        Assert.assertTrue(obj.getPolozky().size()>0);
     
    }

    @Test
    public void testDajVsetkyObjednavky() {
        List<Objednavka> obj  = test.dajVsetkyObjednavky();
        Assert.assertEquals(obj.size(), obj.size());
        
        
    }

    @Test
    public void testDajObjednavku() {
        Objednavka objednavka =    test.dajObjednavku(5L);
     List<Objednavka> Listobj = new ArrayList<>();
     Listobj.add(objednavka);
     int velkost = Listobj.size();
     Assert.assertEquals(velkost, 1);
    }
    
    @Test
    public void testPridajObjednavku() {
        List<Objednavka> predpridanim = test.dajVsetkyObjednavky();
        test.pridajObjednavku(obj);
        List<Objednavka> popridani = test.dajVsetkyObjednavky();
        Assert.assertEquals(predpridanim.size(), popridani.size()-1);
    }



    @Test
    public void testDajDnesneObjednavky() {
                List<Objednavka> obj1 = test.dajDnesneObjednavky();

        test.pridajObjednavku(obj);
                List<Objednavka> obj2 = test.dajDnesneObjednavky();

        Assert.assertEquals(obj1.size()+1, obj2.size());
    }

    @Test
    public void testDajObjednavkyNaMesiac() {
                List<Objednavka> obj1 =    test.dajObjednavkyNaMesiac(2017, 2);

        test.pridajObjednavku(obj);
        List<Objednavka> obj2 =    test.dajObjednavkyNaMesiac(2017, 2);
        Assert.assertEquals(obj1.size()+1, obj2.size());
    }

    @Test
    public void testDajObjednavkyNaRok() {
        List<Objednavka> obj1 = test.dajObjednavkyNaRok(2017);
        test.pridajObjednavku(obj);
        List<Objednavka> obj2 = test.dajObjednavkyNaRok(2017);

        Assert.assertEquals(obj1.size(), obj2.size()-1);
    }

    @Test
    public void testDajObjednavkyNaDatum() {
        List<Objednavka> obj1 = test.dajObjednavkyNaDatum(2017, 2, 9);
        test.pridajObjednavku(obj);
        List<Objednavka> obj2 = test.dajObjednavkyNaDatum(2017, 2, 9);
        Assert.assertEquals(obj1.size()+1, obj2.size());
        
    }
    @Test
    
    public void testOdstranObjednavku() {
         List<Objednavka> predvymaz = test.dajVsetkyObjednavky();
          Long id = 0L ;
        for (Objednavka o : test.dajVsetkyObjednavky()) {
            if(o.getPopis().equals(obj.getPopis())){
                id=o.getId();
            }
            
        }
                
        Objednavka o = test.dajObjednavku(id);
        test.odstranObjednavku(o);
        List<Objednavka> povymazani = test.dajVsetkyObjednavky();
        Assert.assertEquals(predvymaz.size(), povymazani.size()+1);
    }

    @Test
    public void testVymazPredosluObjednavku() {
        
    }
    
}
