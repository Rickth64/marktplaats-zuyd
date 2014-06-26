/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rick
 */
public class BiddingTest {
    
    private static Bidding instance;
    
    public BiddingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Bidding(4567654, BigDecimal.valueOf(9999.99));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdbidding method, of class Bidding.
     */
    @Test
    public void testGetIdbidding() {
        System.out.println("getIdbidding");
        Integer expResult = 4567654;
        Integer result = instance.getIdbidding();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdbidding method, of class Bidding.
     */
    @Test
    public void testSetIdbidding() {
        System.out.println("setIdbidding");
        Integer idbidding = null;
        instance.setIdbidding(idbidding);
        assertEquals(idbidding, instance.getIdbidding());
    }

    /**
     * Test of getAmount method, of class Bidding.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        BigDecimal expResult = BigDecimal.valueOf(9999.99);
        BigDecimal result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount method, of class Bidding.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        BigDecimal amount = BigDecimal.valueOf(1.00);
        instance.setAmount(amount);
        assertEquals(amount, instance.getAmount());
    }

    /**
     * Test of toString method, of class Bidding.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "entity.Bidding[ idbidding=4567654 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
