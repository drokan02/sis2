/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import modelo.VO.Documento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp
 */
public class WorkTest {
    
    public WorkTest() {
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
     * Test of getTitle method, of class Work.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Work instance = new Work();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Work.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Work instance = new Work();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutor method, of class Work.
     */
    @Test
    public void testGetAutor() {
        System.out.println("getAutor");
        Work instance = new Work();
        String expResult = "";
        String result = instance.getAutor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutor method, of class Work.
     */
    @Test
    public void testSetAutor() {
        System.out.println("setAutor");
        String autor = "";
        Work instance = new Work();
        instance.setAutor(autor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFile method, of class Work.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile");
        Work instance = new Work();
        Documento expResult = null;
        Documento result = instance.getFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFile method, of class Work.
     */
    @Test
    public void testSetFile() {
        System.out.println("setFile");
        Documento file = null;
        Work instance = new Work();
        instance.setFile(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComments method, of class Work.
     */
    @Test
    public void testGetComments() {
        System.out.println("getComments");
        Work instance = new Work();
        ArrayList<Comment> expResult = null;
        ArrayList<Comment> result = instance.getComments();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComments method, of class Work.
     */
    @Test
    public void testSetComments() {
        System.out.println("setComments");
        ArrayList<Comment> comments = null;
        Work instance = new Work();
        instance.setComments(comments);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateUpload method, of class Work.
     */
    @Test
    public void testGetDateUpload() {
        System.out.println("getDateUpload");
        Work instance = new Work();
        Date expResult = null;
        Date result = instance.getDateUpload();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateUpload method, of class Work.
     */
    @Test
    public void testSetDateUpload() {
        System.out.println("setDateUpload");
        Date dateUpload = null;
        Work instance = new Work();
        instance.setDateUpload(dateUpload);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
