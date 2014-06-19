/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

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
public class AccountTest {
    
    private static Account instance;
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Account(13542, "uname", "passw", "harry", "potter", "harrypotter@hotmail.com");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdaccount method, of class Account.
     */
    @Test
    public void testGetIdaccount() {
        System.out.println("getIdaccount");
        Integer expResult = 13542;
        Integer result = instance.getIdaccount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdaccount method, of class Account.
     */
    @Test
    public void testSetIdaccount() {
        System.out.println("setIdaccount");
        Integer idaccount = 999;
        instance.setIdaccount(idaccount);
        assertEquals(idaccount, instance.getIdaccount());
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String expResult = "uname";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Account.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "harry.p";
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        String expResult = "passw";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "newpass";
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    /**
     * Test of getFirstName method, of class Account.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "harry";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Account.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Ron";
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of getLastName method, of class Account.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "potter";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Account.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "Weasley";
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of getEmailAdress method, of class Account.
     */
    @Test
    public void testGetEmailAdress() {
        System.out.println("getEmailAdress");
        String expResult = "harrypotter@hotmail.com";
        String result = instance.getEmailAdress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailAdress method, of class Account.
     */
    @Test
    public void testSetEmailAdress() {
        System.out.println("setEmailAdress");
        String emailAdress = "student@hogwarts.wiz";
        instance.setEmailAdress(emailAdress);
        assertEquals(emailAdress, instance.getEmailAdress());
    }

    /**
     * Test of getUsergroupCollection method, of class Account.
     */
    @Test
    public void testGetUsergroupCollection() {
        System.out.println("getUsergroupCollection");
        Collection<Usergroup> expResult = null;
        Collection<Usergroup> result = instance.getUsergroupCollection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsergroupCollection method, of class Account.
     */
    @Test
    public void testSetUsergroupCollection() {
        System.out.println("setUsergroupCollection");
        Collection<Usergroup> usergroupCollection = null;
        instance.setUsergroupCollection(usergroupCollection);
        assertEquals(usergroupCollection, instance.getUsergroupCollection());
    }

    /**
     * Test of hashCode method, of class Account.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Integer id = 13542;
        int expResult = id.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Account.
     */
    //@Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "entity.Account[ idaccount=13542 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
