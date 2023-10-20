package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public interface HelperBase extends ApplicationManager {




    default void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default void click(By locator){
        wd.findElement(locator).click();
    }
//    default void clickDates(By locator,){
//        wd.findElement(locator).click();
//    }

    default void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    default void typeDateStr(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
        click(By.xpath("//div[@class='cdk-overlay-container']"));
    }

   default boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }
    default boolean isAlertPresent() {

        Alert alert = new WebDriverWait(wd,5).until(ExpectedConditions.alertIsPresent());
        if(alert == null)
            return false;

        wd.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept();
        return true;
    }
    default void refresh(){
        wd.navigate().refresh();
    }

//    default void takeScreenshot(String link) {
//        File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
//        File screenshot = new File(link);
//
//        try {
//            Files.copy(tmp, screenshot);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
  default void takeScreenshot(String link) {
    File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
    File screenshot = new File(link);

    try {
        Files.copy(tmp, screenshot);
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

}
