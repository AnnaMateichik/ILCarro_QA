package classworkVersion;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
 @BeforeMethod
 public void precondition(){
  refresh();
  if(isLogged()) logout();

 }

 @Test
    public void registrationPositive(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user);
     submitRegistration();
     logger.info("registrationPositive starts with : "+ user.getName()+" , "+ user.getLastName() +" , " +user.getEmail()  +" & " + user.getPassword());
     pause(5000);

 }
 @Test
    public void registrationNegativeWrongEmail(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user1 = new User(
              "Lara",
              "Kroft",
              "laramail.com",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user1);
     submitRegistration();
  logger.info("registrationNegativeWrongEmail starts with : "+ user1.getName()+" , "+ user1.getLastName() +" , " +user1.getEmail()  +" & " + user1.getPassword());
  //Assert.
  pause(5000);
      Assert.assertTrue(isElementPresent(By.xpath("//*[.='Wrong email format']")));
  pause(5000);
 }
 @Test
    public void registrationNegativeWrongPassword(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              "ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongPassword starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
}
