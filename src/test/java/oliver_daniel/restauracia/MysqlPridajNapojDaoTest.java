/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliver_daniel.restauracia;

import oliver_daniel.restauracia.ObjectFactoryTest;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlPridajNapojDaoTest {

    private MysqlPridajNapojDao test = new MysqlPridajNapojDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());

    public MysqlPridajNapojDaoTest() {
    }

    @Test
    public void testDajNapoje() {
        test.vymazVsetkyNapoje();
        List<Napoj> napoje = test.dajNapoje();
        Assert.assertEquals(0, napoje.size());
    }

    @Test
    public void testPridajNapoj() {

        test.vymazVsetkyNapoje();
        List<Napoj> napoje = test.dajNapoje();
        Napoj n = new Napoj();
        n.setNazov("vodaperliva2");
        n.setCena(2.2);
        test.pridajNapoj(n);
        List<Napoj> napojepo = test.dajNapoje();
        Assert.assertEquals(napoje.size() + 1, napojepo.size());

    }

    @Test
    public void testVymazVsetkyNapoje() {
        test.vymazVsetkyNapoje();
        List<Napoj> napoje = test.dajNapoje();
        Assert.assertEquals(0, napoje.size());
    }

    @Test
    public void testVymazNapoj() {
        test.vymazVsetkyNapoje();
        Napoj n = new Napoj();
        n.setNazov("vodaperliva2");
        n.setCena(2.2);
        test.pridajNapoj(n);
        List<Napoj> napoje = test.dajNapoje();
        Napoj n2 = new Napoj();
        n2.setNazov("vodaperliva");
        n2.setCena(2.2);
        test.vymazNapoj(n2);
        List<Napoj> napojepo = test.dajNapoje();
        Assert.assertEquals(napoje.size(), napojepo.size());

    }

}
