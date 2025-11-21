/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * github link: https://github.com/ST10440462/Programming-POE.git
 */
package accountvalidation;

/**
 *
 * @author OKECHUKU CHIKELU
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Arrays {

    public static final List<Message> sentMessages = new ArrayList<>();
    public static final List<Message> storedMessages = new ArrayList<>();
    public static final List<Message> disregardedMessages = new ArrayList<>();

    //Sent messages
    public static String displaySentMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message m : sentMessages) {
            sb.append("MessageID: ").append(m.getMessageID())
                    .append(" | Sender: Me | Recipient: ").append(m.getRecipient())
                    .append(" | Message: ").append(m.getText())
                    .append("\n");
        }
        return sb.toString();
    }

    //Longest sent messages
    public static Optional<Message> longestSentMessage() {
        if (sentMessages.isEmpty()) {
            return Optional.empty();
        }
        Message longest = Collections.max(sentMessages, (a, b) -> Integer.compare(a.getText().length(), b.getText().length()));
        return Optional.of(longest);
    }

    //Search message ID
    public static Message searchByMessageID(String id) {
        for (Message m : sentMessages) {
            if (m.getMessageID().equals(id)) {
                return m;
            }
        }
        for (Message m : storedMessages) {
            if (m.getMessageID().equals(id)) {
                return m;
            }
        }
        for (Message m : disregardedMessages) {
            if (m.getMessageID().equals(id)) {
                return m;
            }
        }
        return null;
    }

    //Search recipient
    public static List<Message> searchByRecipient(String recipient) {
        List<Message> results = new ArrayList<>();
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(recipient)) {
                results.add(m);
            }
        }
        for (Message m : storedMessages) {
            if (m.getRecipient().equals(recipient)) {
                results.add(m);
            }
        }
        for (Message m : disregardedMessages) {
            if (m.getRecipient().equals(recipient)) {
                results.add(m);
            }
        }
        return results;
    }

    public static boolean deleteByHash(String hash) {
        for (Message m : new ArrayList<>(sentMessages)) {
            if (m.getHash().equals(hash)) {
                sentMessages.remove(m);
                return true;
            }
        }
        for (Message m : new ArrayList<>(storedMessages)) {
            if (m.getHash().equals(hash)) {
                storedMessages.remove(m);
                return true;
            }
        }
        for (Message m : new ArrayList<>(disregardedMessages)) {
            if (m.getHash().equals(hash)) {
                disregardedMessages.remove(m);
                return true;
            }
        }
        return false;
    }

    //display report
    public static String displayReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report: All sent messages\n");
        sb.append("-------------------------\n");
        for (Message m : sentMessages) {
            sb.append("Message Hash: ").append(m.getHash()).append("\n");
            sb.append("Message ID: ").append(m.getMessageID()).append("\n");
            sb.append("Recipient: ").append(m.getRecipient()).append("\n");
            sb.append("Message: ").append(m.getText()).append("\n");
            sb.append("-------------------------\n");
        }
        sb.append("Total messages sent: ").append(sentMessages.size()).append("\n");
        return sb.toString();
    }
}
