/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountvalidation;

/**
 *
 * @author OKECHUKU CHIKELU
 */
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Message {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Message> messages = new ArrayList<>();

    private final String messageID;
    private final String recipient;
    private final String text;
    private final String hash;

    public Message(String messageID, String recipient, String text, String hash) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.text = text;
        this.hash = hash;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getText() {
        return text;
    }

    public String getHash() {
        return hash;
    }

    //launch quickchat
    public static void launchQuickChat() {
        messages = loadMessages();

        System.out.println("Welcome to QuickChat.");
        int choice;

        do {
            System.out.println("QUICKCHAT MENU");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Delete all stored messages");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 ->
                    sendMessages();
                case 2 ->
                    showMessages();
                case 3 ->
                    deleteAllMessages();
                case 4 ->
                    System.out.println("Exiting QuickChat...");
                default ->
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    //send messages
    public static void sendMessages() {
        System.out.print("How many messages do you want to send? ");
        int total = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < total; i++) {
            String messageID = generateMessageID();
            while (!checkMessageID(messageID)) {
                messageID = generateMessageID();
            }

            System.out.print("Enter recipient cell (+: ");
            String recipient = scanner.nextLine();
            while (checkRecipientCell(recipient) == 0) {
                System.out.println("Invalid recipient. Try again.");
                recipient = scanner.nextLine();
            }

            System.out.print("Enter your message (max 250 characters): ");
            String text = scanner.nextLine();
            while (text.length() > 250) {
                System.out.println("Message too long. Try again.");
                text = scanner.nextLine();
            }

            String hash = createMessageHash(messageID, text);
            Message msg = new Message(messageID, recipient, text, hash);

            System.out.println("Choose: [Send / Store / Disregard]");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("send")) {
                messages.add(msg);
                msg.displayMessage();
            } else if (action.equalsIgnoreCase("store")) {
                messages.add(msg);
                storeMessage(msg);
                System.out.println("Message stored.");
            } else {
                System.out.println("Message disregarded.");
            }
        }

        System.out.println("Total messages sent: " + messages.size());
    }

    //show messages
    public static void showMessages() {
        if (messages.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "No messages have been sent or stored yet.",
                    "QuickChat",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        StringBuilder output = new StringBuilder("Recently Sent Messages:\n\n");

        for (Message msg : messages) {
            output.append("Message ID: ").append(msg.getMessageID()).append("\n")
                    .append("Recipient: ").append(msg.getRecipient()).append("\n")
                    .append("Text: ").append(msg.getText()).append("\n")
                    .append("Hash: ").append(msg.getHash()).append("\n")
                    .append("---------------------------\n");
        }

        JOptionPane.showMessageDialog(
                null,
                output.toString(),
                "QuickChat - Recent Messages",
                JOptionPane.INFORMATION_MESSAGE
        /**
         * OpenAI. (2025). ChatGPT (Nov 20 version) [Large language model].
         */
        );
    }

    //delete all messages
    public static void deleteAllMessages() {
        File file = new File("messages.json");
        if (file.exists()) {
            if (file.delete()) {
                messages.clear();
                System.out.println("All stored messages deleted successfully.");
            } else {
                System.out.println("Failed to delete messages file.");
            }
        } else {
            System.out.println("No stored messages found.");
        }
    }

    //generate message ID
    public static String generateMessageID() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    //check message ID
    public static boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    //check cell
    public static int checkRecipientCell(String cell) {
        if (cell.startsWith("+") && cell.length() == 10) {
            return 1;
        }
        return 0;
    }

    //create message hash
    public static String createMessageHash(String id, String msg) {
        String[] words = msg.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return id.substring(0, 2) + ":" + msg.length() + ":" + firstWord + lastWord;
    }

    //store message
    public static void storeMessage(Message msg) {
        JSONObject obj = new JSONObject();
        obj.put("MessageID", msg.messageID);
        obj.put("Recipient", msg.recipient);
        obj.put("Message", msg.text);
        obj.put("Hash", msg.hash);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(obj.toJSONString() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Failed to save message:\n" + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    //load message
    public static ArrayList<Message> loadMessages() {
        ArrayList<Message> loadedMessages = new ArrayList<>();
        File file = new File("messages.json");
        if (!file.exists()) {
            return loadedMessages;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            JSONParser parser = new JSONParser();

            while ((line = reader.readLine()) != null) {
                JSONObject obj = (JSONObject) parser.parse(line);
                String id = (String) obj.get("MessageID");
                String rec = (String) obj.get("Recipient");
                String msg = (String) obj.get("Message");
                String hash = (String) obj.get("Hash");
                loadedMessages.add(new Message(id, rec, msg, hash));
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Failed to load messages:\n" + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return loadedMessages;
    }

    //diplay message
    public void displayMessage() {
        String details = "Message ID: " + messageID + "\n"
                + "Hash: " + hash + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + text;
        JOptionPane.showMessageDialog(null, details);
    }

    @Override
    public String toString() {
        return "MessageID=" + messageID
                + ", Recipient=" + recipient
                + ", Message=" + text
                + ", Hash=" + hash;
    }
}
