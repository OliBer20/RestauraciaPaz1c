/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliver_daniel.restauracia;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlVypisDaoTest {
   private  MysqlVypisDao test = (MysqlVypisDao) ObjectFactoryTest.INSTANCE.getVypis();
    private Objednavka objednavka = new Objednavka();
    
    
    public MysqlVypisDaoTest() {
       
        objednavka.setNazovJedla("Kurča");
        objednavka.setCenaJedla(5);
    }

    @Test
    public void testVymazVsetkyJedla() {
        test.vymazVsetkyJedla();
        List<Objednavka> objednavka = test.dajVsetkyObjednavky();
        Assert.assertEquals(0,objednavka.size());
        
    }

    @Test
    public void testPridajObjednavku() {
        objednavka.setCasObjednavky(new Date(2016 - 1900, Calendar.JANUARY, 1));
        test.vymazVsetkyJedla();
        List<Objednavka> objednavkapred = test.dajVsetkyObjednavky();
        test.pridajObjednavku(objednavka);
        List<Objednavka> objednavkapo = test.dajVsetkyObjednavky();
        Assert.assertEquals(objednavkapred.size()+1, objednavkapo.size());
        
    }

    @Test
    public void testOdstran() {
        objednavka.setCasObjednavky(new Date(2016 - 1900, Calendar.JANUARY, 1));
        test.vymazVsetkyJedla();
        
         test.pridajObjednavku(objednavka);
        
         List<Objednavka> objednavkapop = test.dajVsetkyObjednavky();
         Objednavka objednavka2=new Objednavka();
         for (Objednavka objednavka1 : objednavkapop) {
            objednavka2 = objednavka1;
            break;
        }
        test.Odstran(objednavka2);
        List<Objednavka> objednavkapoods = test.dajVsetkyObjednavky();
        Assert.assertEquals(objednavkapop.size(), objednavkapoods.size()+1);
    }

    @Test
    public void testDajVsetkyObjednavky() {
        test.vymazVsetkyJedla();
        List<Objednavka> objednavka = test.dajVsetkyObjednavky();
        Assert.assertEquals(0, objednavka.size());
    }

    @Test
    public void testDajDnesneObjednavky() {
        test.vymazVsetkyJedla();
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH)-1;
        int mesiac = cal.get(Calendar.MONTH) + 1;
        int rok = cal.get(Calendar.YEAR);
        Date d = new Date(rok, mesiac, den);
        objednavka.setCasObjednavky(d);
        test.pridajObjednavku(objednavka);
        List<Objednavka> objednavky  = test.dajDnesneObjednavky();
        Assert.assertEquals(1, objednavky.size());
    }

    @Test
    public void testDajMesacneObjednavky() {
         test.vymazVsetkyJedla();
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) +1;
        int rok = cal.get(Calendar.YEAR);
        Date d = new Date(rok, mesiac, den);
        objednavka.setCasObjednavky(d);
         List<Objednavka> objednavky = test.dajMesacneObjednavky();
         Assert.assertEquals(1,objednavky.size());
         
    }

    @Test
    public void testDajPodlaMesiaca() {
          test.vymazVsetkyJedla();
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) +1;
        int rok = cal.get(Calendar.YEAR);
        Date d = new Date(rok, mesiac, den);
        objednavka.setCasObjednavky(d);
         List<Objednavka> objednavky = test.dajMesacneObjednavky();
         Assert.assertEquals(1,objednavky.size());
    }

    @Test
    public void testDajPodlaRoka() {
          test.vymazVsetkyJedla();
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) +1;
        int rok = cal.get(Calendar.YEAR);
        Date d = new Date(rok, mesiac, den);
        objednavka.setCasObjednavky(d);
         List<Objednavka> objednavky = test.dajMesacneObjednavky();
         Assert.assertEquals(1,objednavky.size());
    }

    @Test
    public void testDajPodlaDatumu() {
          test.vymazVsetkyJedla();
        Calendar cal = new GregorianCalendar();
        int den = cal.get(Calendar.DAY_OF_MONTH);
        int mesiac = cal.get(Calendar.MONTH) +1;
        int rok = cal.get(Calendar.YEAR);
        Date d = new Date(rok, mesiac, den);
        objednavka.setCasObjednavky(d);
         List<Objednavka> objednavky = test.dajMesacneObjednavky();
         Assert.assertEquals(1,objednavky.size());
    }
    
}
