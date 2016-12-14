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

public class MysqlPridajNapojDaoTest {

    private MysqlPridajNapojDao test = new MysqlPridajNapojDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private Napoj n = new Napoj();

    public MysqlPridajNapojDaoTest() {
        n.setNazov("VodaPerliva");
        n.setCena(1);
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
        test.pridajNapoj(n);
        List<Napoj> napoje = test.dajNapoje();
        test.vymazNapoj(n);
        List<Napoj> napojepo = test.dajNapoje();
        Assert.assertEquals(napoje.size(), napojepo.size()+1);

    }

}
