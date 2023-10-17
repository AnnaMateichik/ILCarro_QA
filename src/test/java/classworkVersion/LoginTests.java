package classworkVersion;

import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LoginTests extends TestBase {

 @BeforeMethod(alwaysRun = true)
 public void precondition(){
     refresh();
     if(isLogged()) logout();
 }
//    @Test
//    public void loginPositiveTest() {
//     String email = "anna@mail.com";
//     String password = "Qq12345$";
//        openLoginForm();
//        fillLoginForm(email,password );
//        submitLogin();
//        logger.info("loginPositiveTest starts with : "+  email +" & " + password);
//        Assert.assertTrue(isLoggedSuccess());
//    }
    @Test(groups = {"positive"})
    public void loginPositiveTestModel() {
     User user = new User().withEmail("anna@mail.com").withPassword("Qq12345$");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        logger.info("loginPositiveTestModel starts with : "+  user.getEmail() +" & " + user.getPassword());
        Assert.assertTrue(isLoggedSuccess());
    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmail() {
        String email = "annamail.com";
        String password = "Qq12345$";
        openLoginForm();
        fillLoginForm(email,password );
//        submitLogin();
        logger.info("loginNegativeTestWrongEmail starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//div[@class = 'error']")));
//        pause(5000);
    }
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmailTwoA() {
        String email = "anna@mail@.com";
        String password = "Qq12345$";
        openLoginForm();
        fillLoginForm(email,password );
//        submitLogin();
        logger.info("loginNegativeTestWrongEmailTwoA starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//div[@class = 'error']")));
//        pause(5000);
    }
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongEmail1() {
        String email = "anna@mailcom";
        String password = "Qq12345$";
        openLoginForm();
        fillLoginForm(email,password );
        submitLogin();
        logger.info("loginNegativeTestWrongEmail1 starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//*[. = 'Login failed']")));
//        pause(5000);
    }
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPassword() {
        String email = "anna@mailcom";
        String password = "qq12345$";
        openLoginForm();
        fillLoginForm(email,password );
        submitLogin();
        logger.info("loginNegativeTestWrongPassword starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//*[. = 'Login failed']")));
//        pause(5000);
    }
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPassword1() {
        String email = "anna@mailcom";
        String password = "Qq123456";
        openLoginForm();
        fillLoginForm(email,password );
        submitLogin();
        logger.info("loginNegativeTestWrongPassword1 starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//*[. = 'Login failed']")));
//        pause(5000);
    }
    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPassword2() {
        String email = "anna@mailcom";
        String password = "Qq12345678912345678564346$";
        openLoginForm();
        fillLoginForm(email,password );
        submitLogin();
        logger.info("loginNegativeTestWrongPassword2 starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//*[. = 'Login failed']")));
//        pause(5000);
    }
    @Test(groups = {"negative","smoke"})
    public void loginNegativeTestWrongPassword3() {
        String email = "anna@mailcom";
        String password = "Qq1234$";
        openLoginForm();
        fillLoginForm(email,password );
        submitLogin();
        logger.info("loginNegativeTestWrongPassword3 starts with : "+  email +" & " + password);
//        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//*[. = 'Login failed']")));
//        pause(5000);
    }
    @AfterMethod(alwaysRun = true)
    public void postcondition() {
     if( isElementPresent(By.xpath("//button[@type='button']"))){
        clickOkButton();}
    }

}