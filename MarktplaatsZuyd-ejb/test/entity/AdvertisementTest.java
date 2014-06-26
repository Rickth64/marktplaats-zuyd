/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.math.BigDecimal;
import java.util.Collection;
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
public class AdvertisementTest {
    
    private static Advertisement instance;
    
    public AdvertisementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Advertisement(313, "title of the ad", "descriptionnnnnn", BigDecimal.valueOf(123.78), "seller@hotmail.com", "0612345678", "Homestreet 123");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdadvertisement method, of class Advertisement.
     */
    @Test
    public void testGetIdadvertisement() {
        System.out.println("getIdadvertisement");
        Integer expResult = 313;
        Integer result = instance.getIdadvertisement();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdadvertisement method, of class Advertisement.
     */
    @Test
    public void testSetIdadvertisement() {
        System.out.println("setIdadvertisement");
        Integer idadvertisement = 1234;
        instance.setIdadvertisement(idadvertisement);
        assertEquals(idadvertisement, instance.getIdadvertisement());
    }

    /**
     * Test of getName method, of class Advertisement.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "title of the ad";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Advertisement.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "another title!";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getDescription method, of class Advertisement.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String expResult = "descriptionnnnnn";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Advertisement.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "I am selling this thing :) !";
        instance.setDescription(description);
        assertEquals(description, instance.getDescription());
    }

    /**
     * Test of getPrice method, of class Advertisement.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        BigDecimal expResult = BigDecimal.valueOf(123.78);
        BigDecimal result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrice method, of class Advertisement.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        BigDecimal price = BigDecimal.valueOf(0.00);
        instance.setPrice(price);
        assertEquals(price, instance.getPrice());
    }

    /**
     * Test of getContactemail method, of class Advertisement.
     */
    @Test
    public void testGetContactemail() {
        System.out.println("getContactemail");
        String expResult = "seller@hotmail.com";
        String result = instance.getContactemail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactemail method, of class Advertisement.
     */
    @Test
    public void testSetContactemail() {
        System.out.println("setContactemail");
        String contactemail = "newmail@mymail.nl";
        instance.setContactemail(contactemail);
        assertEquals(contactemail, instance.getContactemail());
    }

    /**
     * Test of getContactphone method, of class Advertisement.
     */
    @Test
    public void testGetContactphone() {
        System.out.println("getContactphone");
        String expResult = "0612345678";
        String result = instance.getContactphone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactphone method, of class Advertisement.
     */
    @Test
    public void testSetContactphone() {
        System.out.println("setContactphone");
        String contactphone = "0031455250000";
        instance.setContactphone(contactphone);
        assertEquals(contactphone, instance.getContactphone());
    }

    /**
     * Test of getContactaddress method, of class Advertisement.
     */
    @Test
    public void testGetContactaddress() {
        System.out.println("getContactaddress");
        String expResult = "Homestreet 123";
        String result = instance.getContactaddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactaddress method, of class Advertisement.
     */
    @Test
    public void testSetContactaddress() {
        System.out.println("setContactaddress");
        String contactaddress = "new address 321";
        instance.setContactaddress(contactaddress);
        assertEquals(contactaddress, instance.getContactaddress());
    }

    /**
     * Test of toString method, of class Advertisement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "entity.Advertisement[ idadvertisement=313 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
