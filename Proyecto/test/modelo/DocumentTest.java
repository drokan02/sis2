/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raul
 */
public class DocumentTest {
    File file;
    Document doc;
    public DocumentTest() {
        file = new File("C:\\Users\\Raul\\Documents\\Problemas _Tema3_II_resueltos.pdf");
        doc = new Document(file);
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
     * Test of getDocument method, of class Document.
     */
    @Test
    public void testGetDocument() {
        File fil = new File("C:\\Users\\Raul\\Documents\\Problemas _Tema3_II_resueltos.pdf");
        assertEquals(file, doc.getDocument());
    }

    /**
     * Test of setFile method, of class Document.
     */
    @Test
    public void testSetFile(){
       File fil = new File("C:\\Users\\Raul\\Documents\\Libro3.xlsx");
       doc.setFile(fil);
       boolean igual = file.equals(doc.getDocument());
        assertEquals(false, igual);
    }

    /**
     * Test of validateDocument method, of class Document.
     */
    @Test
    public void testValidateDocument() {
        String [] ext = {"xlsx","pdf","doc"};
        boolean res = doc.validateDocument(ext);
        assertEquals(false, res);
    }
    
}
