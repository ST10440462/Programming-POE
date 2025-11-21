/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package accountvalidation;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OKECHUKU CHIKELU
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = null;
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetText() {
        System.out.println("getText");
        Message instance = null;
        String expResult = "";
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHash() {
        System.out.println("getHash");
        Message instance = null;
        String expResult = "";
        String result = instance.getHash();
        assertEquals(expResult, result);
    }

    @Test
    public void testLaunchQuickChat() {
        System.out.println("launchQuickChat");
        Message.launchQuickChat();
    }

    @Test
    public void testSendMessages() {
        System.out.println("sendMessages");
        Message.sendMessages();
    }

    @Test
    public void testShowMessages() {
        System.out.println("showMessages");
        Message.showMessages();
    }

    @Test
    public void testDeleteAllMessages() {
        System.out.println("deleteAllMessages");
        Message.deleteAllMessages();
    }

    @Test
    public void testGenerateMessageID() {
        System.out.println("generateMessageID");
        String expResult = "";
        String result = Message.generateMessageID();
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String id = "8762198290";
        boolean expResult = false;
        boolean result = Message.checkMessageID(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cell = "+27789811484";
        int expResult = 0;
        int result = Message.checkRecipientCell(cell);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String id = "";
        String msg = "";
        String expResult = "";
        String result = Message.createMessageHash(id, msg);
        assertEquals(expResult, result);
    }

    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message msg = null;
        Message.storeMessage(msg);
    }

    @Test
    public void testLoadMessages() {
        System.out.println("loadMessages");
        ArrayList<Message> expResult = null;
        ArrayList<Message> result = Message.loadMessages();
        assertEquals(expResult, result);
    }

    @Test
    public void testDisplayMessage() {
        System.out.println("displayMessage");
        Message instance = null;
        instance.displayMessage();
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Message instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
