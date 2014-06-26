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
public class CategoryTest {
    
    private static Category instance;
    
    public CategoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Category(1, "a/v receivers");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdcategory method, of class Category.
     */
    @Test
    public void testGetIdcategory() {
        System.out.println("getIdcategory");
        Integer expResult = 1;
        Integer result = instance.getIdcategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdcategory method, of class Category.
     */
    @Test
    public void testSetIdcategory() {
        System.out.println("setIdcategory");
        Integer idcategory = 21;
        instance.setIdcategory(idcategory);
        assertEquals(idcategory, instance.getIdcategory());
    }

    /**
     * Test of getName method, of class Category.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "a/v receivers";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Category.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "smartphones";
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of toString method, of class Category.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "entity.Category[ idcategory=1 ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
