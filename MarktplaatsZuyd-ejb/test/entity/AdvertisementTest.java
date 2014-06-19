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
        Advertisement instance = new Advertisement();
        Integer expResult = null;
        Integer result = instance.getIdadvertisement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdadvertisement method, of class Advertisement.
     */
    @Test
    public void testSetIdadvertisement() {
        System.out.println("setIdadvertisement");
        Integer idadvertisement = null;
        Advertisement instance = new Advertisement();
        instance.setIdadvertisement(idadvertisement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Advertisement.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Advertisement.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Advertisement instance = new Advertisement();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Advertisement.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Advertisement.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Advertisement instance = new Advertisement();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Advertisement.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Advertisement instance = new Advertisement();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Advertisement.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        BigDecimal price = null;
        Advertisement instance = new Advertisement();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactemail method, of class Advertisement.
     */
    @Test
    public void testGetContactemail() {
        System.out.println("getContactemail");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.getContactemail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactemail method, of class Advertisement.
     */
    @Test
    public void testSetContactemail() {
        System.out.println("setContactemail");
        String contactemail = "";
        Advertisement instance = new Advertisement();
        instance.setContactemail(contactemail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactphone method, of class Advertisement.
     */
    @Test
    public void testGetContactphone() {
        System.out.println("getContactphone");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.getContactphone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactphone method, of class Advertisement.
     */
    @Test
    public void testSetContactphone() {
        System.out.println("setContactphone");
        String contactphone = "";
        Advertisement instance = new Advertisement();
        instance.setContactphone(contactphone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactaddress method, of class Advertisement.
     */
    @Test
    public void testGetContactaddress() {
        System.out.println("getContactaddress");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.getContactaddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactaddress method, of class Advertisement.
     */
    @Test
    public void testSetContactaddress() {
        System.out.println("setContactaddress");
        String contactaddress = "";
        Advertisement instance = new Advertisement();
        instance.setContactaddress(contactaddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBiddingCollection method, of class Advertisement.
     */
    @Test
    public void testGetBiddingCollection() {
        System.out.println("getBiddingCollection");
        Advertisement instance = new Advertisement();
        Collection<Bidding> expResult = null;
        Collection<Bidding> result = instance.getBiddingCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBiddingCollection method, of class Advertisement.
     */
    @Test
    public void testSetBiddingCollection() {
        System.out.println("setBiddingCollection");
        Collection<Bidding> biddingCollection = null;
        Advertisement instance = new Advertisement();
        instance.setBiddingCollection(biddingCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoryIdcategory method, of class Advertisement.
     */
    @Test
    public void testGetCategoryIdcategory() {
        System.out.println("getCategoryIdcategory");
        Advertisement instance = new Advertisement();
        Category expResult = null;
        Category result = instance.getCategoryIdcategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoryIdcategory method, of class Advertisement.
     */
    @Test
    public void testSetCategoryIdcategory() {
        System.out.println("setCategoryIdcategory");
        Category categoryIdcategory = null;
        Advertisement instance = new Advertisement();
        instance.setCategoryIdcategory(categoryIdcategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountIdaccount method, of class Advertisement.
     */
    @Test
    public void testGetAccountIdaccount() {
        System.out.println("getAccountIdaccount");
        Advertisement instance = new Advertisement();
        Account expResult = null;
        Account result = instance.getAccountIdaccount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountIdaccount method, of class Advertisement.
     */
    @Test
    public void testSetAccountIdaccount() {
        System.out.println("setAccountIdaccount");
        Account accountIdaccount = null;
        Advertisement instance = new Advertisement();
        instance.setAccountIdaccount(accountIdaccount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Advertisement.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Advertisement instance = new Advertisement();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Advertisement.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Advertisement instance = new Advertisement();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Advertisement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Advertisement instance = new Advertisement();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
