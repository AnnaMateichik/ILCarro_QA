package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

        @AfterMethod
        public void tearDown(){
            wd.quit();
        }

    public void openLoginForm(){

        wd.findElement(By.xpath("//div//*[@ng-reflect-router-link='login']")).click();
    }

    public void fillLoginForm(String email,String password){

type(By.xpath("//*[@id='email']"),email);
type(By.xpath("//*[@id='password']"),password);


    }

    public void type(By locator,String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);


    }

    public void submitLogin(){
        wd.findElement(By.xpath("//*[@type='submit']")).click();
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size()>0;

    }
    public void okClick()
    {
        wd.findElement(By.xpath("//*[@class='positive-button ng-star-inserted']")).click();
    }


}
