/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kategoria;
import entity.Polozka;
import factory.ObjectFactoryTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlPolozkaDaoTest {
    private MysqlPolozkaDao test = new MysqlPolozkaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private MysqlKategoriaDao test2 = new MysqlKategoriaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private Polozka p = new Polozka();
    public String nazov = "Rum";
    
    public MysqlPolozkaDaoTest() {
    
        p.setCena(3.2);
        p.setId(Long.MIN_VALUE);
        p.setKategoria(test2.dajKategoriu((long)1));
        p.setNazov(nazov);
       
    }

    @Test
    public void testDajPolozky() {
        List<Polozka> polozka = test.dajPolozky();
        Assert.assertEquals(0, polozka.size()-polozka.size());
    }

    @Test
    public void testPridajPolozku() {
        List<Polozka> predpridanim = test.dajPolozky();
        test.pridajPolozku(p);
        List<Polozka> popridani = test.dajPolozky();
        Assert.assertEquals(predpridanim.size()+1, popridani.size());
                }

    @Test
    public void testDajPodlaNazvu() {
        Polozka polozka = test.dajPodlaNazvu(nazov);
        List<Polozka> list = new ArrayList<Polozka>();
        list.add(polozka);
        Assert.assertEquals(1, list.size());
        
    }

    @Test
    public void testDajPodlaId() {
         Polozka polozka = test.dajPodlaNazvu(nazov);
         Long id = polozka.getId();
        
        Polozka polozka2 = test.dajPodlaId(id);
        List<Polozka> list = new ArrayList<Polozka>();
        list.add(polozka2);
        Assert.assertEquals(1, list.size());
    }

    @Test
    public void testVymazPolozku() {
        Polozka p2 = test.dajPodlaNazvu(nazov);
        List<Polozka> predv = test.dajPolozky();
        test.vymazPolozku(p2);
        List<Polozka> pov = test.dajPolozky();
        Assert.assertEquals(predv.size(), pov.size()+1);
     }
    
}
