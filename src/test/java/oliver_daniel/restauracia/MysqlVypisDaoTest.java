/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  oliver_daniel.restauracia;

import oliver_daniel.restauracia.ObjectFactoryTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class MysqlVypisDaoTest {
    private MysqlVypisDao test = new MysqlVypisDao(ObjectFactoryTest.INSTANCE.getJdbcTemplate());
    public MysqlVypisDaoTest() {
    }

    @Test
    public void testVymazVsetkyJedla() {
       
    }

    @Test
    public void testPridajObjednavku() {
      
    }

    @Test
    public void testVyberPodlaDatumu() {
       
    }

    @Test
    public void testDajVsetkyObjednavky() {
        
    }

    @Test
    public void testDajDnesneObjednavky() {
        
    }

    @Test
    public void testDajMesacneObjednavky() {
      
    }

    @Test
    public void testDajPodlaMesiaca() {
      
    }

    @Test
    public void testDajPodlaRoka() {
       
    }

    @Test
    public void testDajPodlaDatumu() {
        
    }
    
}
