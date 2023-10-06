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
    public void registrationNegativeWrongEmailNoDot(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user1 = new User(
              "Lara",
              "Kroft",
              "lara@mailcom",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user1);
     submitRegistration();
  logger.info("registrationNegativeWrongEmailNoDot starts with : "+ user1.getName()+" , "+ user1.getLastName() +" , " +user1.getEmail()  +" & " + user1.getPassword());
  //Assert.
  pause(5000);
      Assert.assertTrue(isElementPresent(By.xpath("//*[.='Wrong email format']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeWrongEmailNul(){
  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user1 = new User(
          "Lara",
          "Kroft",
          "",
          "Ll12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user1);
  submitRegistration();
  logger.info("registrationNegativeWrongEmailNul starts with : "+ user1.getName()+" , "+ user1.getLastName() +" , " +user1.getEmail()  +" & " + user1.getPassword());
  //Assert.
  pause(5000);
  Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeWrongEmailTwo(){
  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user1 = new User(
          "Lara",
          "Kroft",
          "lara@mail@.com",
          "Ll12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user1);
  submitRegistration();
  logger.info("registrationNegativeWrongEmailTwo starts with : "+ user1.getName()+" , "+ user1.getLastName() +" , " +user1.getEmail()  +" & " + user1.getPassword());
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
 @Test
    public void registrationNegativeWrongPasswordWithoutSpecialSymbol(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              "Ll123456"

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongPasswordWithoutSpecialSymbol starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
 @Test
    public void registrationNegativeWrongPasswordLessThanEight(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              "Ll1234$"

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongPasswordLessThanEight starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
// @Test
//    public void registrationNegativeWrongPasswordManySymbols(){
//     int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//
//      User user2 = new User(
//              "Lara",
//              "Kroft",
//              "lara" + i + "@mail.com",
//              "Ll123456891234567891234567890123344567563576487656765438786$"
//
//      );
//
//     openRegistrationForm();
//     fillRegistrationForm(user2);
//     submitRegistration();
//  logger.info("registrationNegativeWrongPassword starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
//     pause(5000);
//     Assert.assertTrue(isElementPresent(By.xpath("//*[.='Registration failed']")));
//  pause(5000);
// }
 @Test
    public void registrationNegativeWrongPasswordNul(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              ""

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongPasswordNul starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
 @Test
    public void registrationNegativeWrongPasswordSpace(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              "Lara",
              "Kroft",
              "lara" + i + "@mail.com",
              " "

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongPasswordSpace starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[@class='error']")));
  pause(5000);
 }
 @Test
    public void registrationNegativeWrongName(){
     int i = (int)(System.currentTimeMillis()/1000)%3600;


      User user2 = new User(
              " ",
              "Kroft",
              "lara" + i + "@mail.com",
              "Ll12345$"

      );

     openRegistrationForm();
     fillRegistrationForm(user2);
     submitRegistration();
  logger.info("registrationNegativeWrongName starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
     pause(5000);
     Assert.assertTrue(isElementPresent(By.xpath("//*[.='Registration failed']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeWrongNameNul(){
  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user2 = new User(
          "",
          "Kroft",
          "lara" + i + "@mail.com",
          "Ll12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user2);
  submitRegistration();
  logger.info("registrationNegativeWrongNameNul starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
  pause(5000);
  Assert.assertTrue(isElementPresent(By.xpath("//*[.=' Name is required ']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeWrongLastNameNul(){
  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user2 = new User(
          "Lara",
          "",
          "lara" + i + "@mail.com",
          "Ll12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user2);
  submitRegistration();
  logger.info("registrationNegativeWrongLastNameNul starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
  pause(5000);
  Assert.assertTrue(isElementPresent(By.xpath("//*[.= ' Last name is required ']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeWrongLastName(){
  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user2 = new User(
          "Lara",
          " ",
          "lara" + i + "@mail.com",
          "Ll12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user2);
  submitRegistration();
  logger.info("registrationNegativeWrongLastName starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
  pause(5000);
  Assert.assertTrue(isElementPresent(By.xpath("//*[.='Registration failed']")));
  pause(5000);
 }
 @Test
 public void registrationNegativeUserAlreadyExists(){
//  int i = (int)(System.currentTimeMillis()/1000)%3600;


  User user2 = new User(
          "Anna",
          "Ma",
          "anna@mail.com",
          "Qq12345$"

  );

  openRegistrationForm();
  fillRegistrationForm(user2);
  submitRegistration();
  logger.info("registrationNegativeUserAlreadyExists starts with : "+ user2.getName()+" , "+ user2.getLastName() +" , " +user2.getEmail()  +" & " + user2.getPassword());
  pause(5000);
  Assert.assertTrue(isElementPresent(By.xpath("//*[.='Registration failed']")));
  pause(5000);
 }
 @AfterMethod
 public void postcondition() {
  if( isElementPresent(By.xpath("//button[@type='button']"))){
   clickOkButton();}
 }
}
