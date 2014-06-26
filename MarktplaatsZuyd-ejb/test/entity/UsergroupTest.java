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
public class UsergroupTest {
    
    private static Usergroup instance;
    
    public UsergroupTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Usergroup(99, "WIZARD");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdgroup method, of class Usergroup.
     */
    @Test
    public void testGetIdgroup() {
        System.out.println("getIdgroup");
        Integer expResult = 99;
        Integer result = instance.getIdgroup();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdgroup method, of class Usergroup.
     */
    @Test
    public void testSetIdgroup() {
        System.out.println("setIdgroup");
        Integer idgroup = 1;
        instance.setIdgroup(idgroup);
        assertEquals(idgroup, instance.getIdgroup());
    }

    /**
     * Test of getName method, of class Usergroup.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "WIZARD";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Usergroup.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "ADMIN";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of toString method, of class Usergroup.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "entity.Usergroup[ idgroup=99 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
