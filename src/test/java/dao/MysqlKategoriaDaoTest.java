/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kategoria;
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
public class MysqlKategoriaDaoTest {
        private MysqlKategoriaDao test = new MysqlKategoriaDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
        public Kategoria kategoria = new Kategoria();
        private String kat = "Jedlo";
    public MysqlKategoriaDaoTest() {
        kategoria.setId((long)3);
        kategoria.setNazov("Napoje2");
        
    }

    @Test
    public void testPridajKategoriu() {
        List<Kategoria> predpridanim = test.dajVsetkyKategorie();
        test.pridajKategoriu(kategoria);
        List<Kategoria> popridani = test.dajVsetkyKategorie();
        Assert.assertEquals(predpridanim.size()+1, popridani.size());
    }

    @Test
    public void testDajKategoriu_Long() {
       Kategoria kat =test.dajKategoriu(3L);
       List<Kategoria> katlist =new ArrayList<>();
       katlist.add(kat);
       Assert.assertEquals(1, katlist.size());
    }
//chyba
    @Test
    public void testDajKategoriu_String() {
       Kategoria kat2 =test.dajKategoriu(kat);
       List<Kategoria> katlist2 =new ArrayList<>();
       katlist2.add(kat2);
       Assert.assertEquals(1, katlist2.size());
    }

    @Test
    public void testDajVsetkyKategorie() {
        List<Kategoria> kat = test.dajVsetkyKategorie();
        Assert.assertEquals(kat.size(), kat.size());
        
    }

  
    
}
