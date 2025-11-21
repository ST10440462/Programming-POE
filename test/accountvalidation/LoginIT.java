/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package accountvalidation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author OKECHUKU CHIKELU
 */
public class LoginIT {

    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "Kyl_e";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Sooterunfool46#";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        String phone = "+27789811484";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(phone);
        assertEquals(expResult, result);
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "Kyl_e";
        String password = "Sooterunfool46#";
        String phone = "+27789811484";
        Login instance = new Login();
        String expResult = "The user has been registered successfully.";
        String result = instance.registerUser(username, password, phone);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "Kyl_e";
        String password = "Sooterunfool46#";
        String phone = "+27789811484";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(username, password, phone);
        assertEquals(expResult, result);
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "Kyl_e";
        String password = "Sooterunfool46#";
        String phone = "+27789811484";
        Login instance = new Login();
        String expResult = "welcome" + username + "it is great to see you again.";
        String result = instance.returnLoginStatus(username, password, phone);
        assertEquals(expResult, result);
    }

}
