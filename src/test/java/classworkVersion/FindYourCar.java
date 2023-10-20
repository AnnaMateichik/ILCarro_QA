package classworkVersion;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindYourCar extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(isLogged() == false){
            login(
//                    new User()
//                            .withEmail(email)
//                            .withPassword(password)
                    new User()
                            .withEmail("anna@mail.com")
                            .withPassword("Qq12345$")

            );

        }
    }

//    @Test
//    public void FindCarDataStr(){
//        typeLocationCity("Florence");
//        typeDate("20/10/2023");
//        click(By.xpath("//*[@type='submit']"));
//        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='search-results']")));
//
//    }
//    @Test
//    public void FindCarDataThisMonth(){
//        typeLocationCity("Florence");
//        typeDate("20/10/2023");
//        click(By.xpath("//*[@type='submit']"));
//        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='search-results']")));
//
//    }
}
