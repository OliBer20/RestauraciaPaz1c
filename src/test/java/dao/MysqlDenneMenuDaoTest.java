/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kategoria;
import entity.Polozka;
import factory.ObjectFactoryTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class MysqlDenneMenuDaoTest {
    
    private MysqlDenneMenuDao test = new MysqlDenneMenuDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private Polozka polozka = new Polozka();
    private Kategoria kategoria = new Kategoria();
    
    public MysqlDenneMenuDaoTest() {
        
             polozka.setCena(3.5);
             polozka.setId((long)1);
             polozka.setKategoria(kategoria);
             polozka.setNazov("Caj");
    }

    @Test
    public void testZiskajDenneMenu() {
        List<Polozka> jedlalistpred = test.ziskajDenneMenu();
       test.vymazVsetko();
           List<Polozka> jedlalist = test.ziskajDenneMenu();
           Assert.assertEquals(jedlalistpred.size(), jedlalist.size()+jedlalistpred.size());     
    }
    

    @Test
    public void testPridaj() {
        List<Polozka> predpridanim = test.ziskajDenneMenu();
        test.pridaj((long)21);
        List<Polozka> popridani = test.ziskajDenneMenu();
        Assert.assertEquals(popridani.size(), predpridanim.size()+1);
        test.vymazVsetko();
    }

    @Test
    public void testOdober() {
       test.pridaj((long)21);
       List<Polozka> predodobratim = test.ziskajDenneMenu();
       test.odober(polozka);
       List<Polozka> poodobrati = test.ziskajDenneMenu();
       Assert.assertEquals(predodobratim.size(), poodobrati.size()+1);
    }

    @Test
    public void testVymazVsetko() {
        test.vymazVsetko();
        List<Polozka>vsetko= test.ziskajDenneMenu();
         Assert.assertEquals(0, vsetko.size());  
         
        
    }
    
}
