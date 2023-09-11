package classworkVersion;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

 @BeforeMethod
 public void precondition(){
     if(isLogged()) logout();
 }
//    @Test
//    public void loginPositiveTest() {
//        openLoginForm();
//        fillLoginForm("anna@mail.com", "Qq12345$");
//        submitLogin();
//        Assert.assertTrue(isLoggedSuccess());
//    }
    @Test
    public void loginPositiveTest1() {
     User user = new User().withEmail("anna@mail.com").withPassword("Qq12345$");
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition() {
        clickOkButton();
    }

}