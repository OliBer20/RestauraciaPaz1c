/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.uzivatel;
import factory.ObjectFactoryTest;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlUzivatelDaoTest {
    private MysqlUzivatelDao test = new MysqlUzivatelDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
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
