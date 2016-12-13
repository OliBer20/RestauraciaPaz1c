
package oliver_daniel.restauracia;

import oliver_daniel.restauracia.ObjectFactoryTest;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class MysqlCenyJedalDaoTest {

    private MysqlCenyJedalDao test = new MysqlCenyJedalDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    private jedloSCenou testjedlo = new jedloSCenou();

    public MysqlCenyJedalDaoTest() {
        testjedlo.setCena(3);
        testjedlo.setJedlo("Omacka");
    }

    @Test
    public void testVymazVsetkyJedla() {
        test.vymazVsetkyJedla();
        List<jedloSCenou> jedlolist = test.dajJedlaSCenami();
        Assert.assertEquals(0, jedlolist.size());
    }

    @Test
    public void testPridajJedlo() {

        test.vymazVsetkyJedla();
        test.pridajJedlo(testjedlo);
        List<jedloSCenou> jedlolist = test.dajJedlaSCenami();
        Assert.assertEquals(1, jedlolist.size());

    }

    public void testDajJedlaSCenami() {

        List<jedloSCenou> jedlolist = test.dajJedlaSCenami();
        test.vymazVsetkyJedla();
        Assert.assertEquals(0, jedlolist.size());

    }

    @Test
    public void testZiskajCenu() {

       
        test.vymazVsetkyJedla();
        test.pridajJedlo(testjedlo);
        List<jedloSCenou> jedlolist = test.dajJedlaSCenami();

        Assert.assertEquals(1, jedlolist.size());
    }

    @Test
    public void testVymazJedlo() {

        
        test.vymazVsetkyJedla();
        test.pridajJedlo(testjedlo);
        List<jedloSCenou> jedlolist = test.dajJedlaSCenami();
        test.vymazJedlo(testjedlo);
        List<jedloSCenou> jedlolistvymaz = test.dajJedlaSCenami();
        Assert.assertEquals(jedlolist.size(),jedlolistvymaz.size()+1);

    }

}
