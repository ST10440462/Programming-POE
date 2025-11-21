/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package accountvalidation;

import java.util.List;
import java.util.Optional;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author OKECHUKU CHIKELU
 */
public class ArraysNGTest {

    public ArraysNGTest() {
    }

    @Test
    public void testDisplaySentMessages() {
        System.out.println("displaySentMessages");
        String expResult = "";
        String result = Arrays.displaySentMessages();
        assertEquals(result, expResult);
    }

    @Test
    public void testLongestSentMessage() {
        System.out.println("longestSentMessage");
        Optional expResult = null;
        Optional result = Arrays.longestSentMessage();
        assertEquals(result, expResult);
    }

    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        String id = "";
        Message expResult = null;
        Message result = Arrays.searchByMessageID(id);
        assertEquals(result, expResult);
    }

    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        String recipient = "";
        List expResult = null;
        List result = Arrays.searchByRecipient(recipient);
        assertEquals(result, expResult);
    }

    @Test
    public void testDeleteByHash() {
        System.out.println("deleteByHash");
        String hash = "";
        boolean expResult = false;
        boolean result = Arrays.deleteByHash(hash);
        assertEquals(result, expResult);
    }

    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        String expResult = "";
        String result = Arrays.displayReport();
        assertEquals(result, expResult);
    }

}
