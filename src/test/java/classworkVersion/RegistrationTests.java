package classworkVersion;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
 @Test
    public void registrationPositive(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user = new User(
              "Lara",
              "Kroft",
              "Lara" + i + "@mail.com",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user);
     submitRegistration();


 }
 @Test
    public void registrationNegativeWrongEmail(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user = new User(
              "Lara",
              "Kroft",
              "Laramail.com",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user);
     submitRegistration();
  //Assert.
  pause(5000);
      Assert.assertTrue(isElementPresent(By.xpath("//*[.='Wrong email format']")));

 }
 @Test
    public void registrationNegativeWrongPassword(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user = new User(
              "Lara",
              "Kroft",
              "Lara" + i + "@mail.com",
              "ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user);
     submitRegistration();
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
 }
}
