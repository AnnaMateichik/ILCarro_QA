package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
    openLoginForm();
    fillLoginForm("anna@mail.com","Qq12345$");
    submitLogin();
    okClick();
    Assert.assertTrue(isElementPresent(By.xpath("//*[.=' Logout ']")));
   

    }
}
