/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accountvalidation;

/**
 *
 * @author OKECHUKU CHIKELU
 */
import javax.swing.JOptionPane;

public class AccountValidation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
            Login auth = new Login();

            JOptionPane.showMessageDialog(null, "User Registration");

            String registerMessage;

            String username = JOptionPane.showInputDialog(null, "Enter username:");

            String password = JOptionPane.showInputDialog(null, "Enter password:");

            String phone = JOptionPane.showInputDialog(null, "Enter cellphone number:");

            // Register user
            registerMessage = auth.registerUser(username, password, phone);
            System.out.println(registerMessage);

            if (registerMessage.equals("The user has been registered successfully.")) {
            } else {
                System.out.println("Registration failed. Please try again.");
            }

            JOptionPane.showMessageDialog(null, "User Login");

            String loginUsername = JOptionPane.showInputDialog(null, "Enter username:");

            String loginPassword = JOptionPane.showInputDialog(null, "Enter Password:");

            String loginPhone = JOptionPane.showInputDialog(null, "Enter cell phone number:");

            // Attempt login
            String loginStatus = auth.returnLoginStatus(loginUsername, loginPassword, loginPhone);
            System.out.println(loginStatus);

            if (loginStatus.equals("Welcome" + username + "it is great to see you again.")) {
                Message.launchQuickChat();
            }
        }
    }
}
