/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountvalidation;

/**
 *
 * @author OKECHUKU CHIKELU
 */
public class Login {

    private String storedUsername;
    private String storedPassword;
    private String storedPhone;

    //check username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    //check password
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        if (password.length() < 8) {
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasDigit && hasSpecial;
    }

    //check cell phone number
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
        /**
         * OpenAI. (2025). ChatGPT (Sep 19 version) [Large language model].
         * https://chatgpt.com/share/68cd314a-a5a8-8012-88f1-eb49648206f3
         */
    }

    //register user
    public String registerUser(String username, String password, String phone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.storedUsername = username;
        this.storedPassword = password;
        this.storedPhone = phone;

        return "The user has been registered successfully.";
    }

    //login user
    public boolean loginUser(String username, String password, String phone) {
        return username.equals(storedUsername) && password.equals(storedPassword) && phone.equals(storedPhone);
    }

    //return login status
    public String returnLoginStatus(String username, String password, String phone) {
        if (loginUser(username, password, phone)) {
            return "Welcome" + username + "it is great to see you again.";
        } else {
            return "Username or password incorrect please try again.";
        }
    }
}
