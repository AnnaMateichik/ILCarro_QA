package classworkVersion;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindYourCarTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        refresh();
//        if(isLogged() == false){
//            login(
//                   getEmail(),getPassword()
//            );
//        }
    }

    @Test
    public void FindCarDataStr(){  //negative
        openSearchCarForm();
        typeLocationCity("Malta");
        typeDate("20/10/2023");
        clickYallaBtn();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='ng-star-inserted']")));

    }
    @Test(groups = {"positive"})
    public void FindCarDataThisMonth(){
        openSearchCarForm();
        typeLocationCity("Florence");
        typeDateCalendar("23","26");
        clickYallaBtn();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='search-results']")));
    }
    @Test(groups = {"positive"})
    public void FindCarDataDifferentMonth(){
        openSearchCarForm();
        typeLocationCity("Moscow");
        typeDateCalendarMonth("2023","DEC","1", "5");
        clickYallaBtn();
        Assert.assertTrue(isElementPresent(By.xpath("//*[@class='search-results']")));
    }


}
