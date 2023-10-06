package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public interface ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
//    WebDriver wd= new ChromeDriver();
    //new field

   EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());


   default void init() {
        //wd = new ChromeDriver();
//       wd.manage().window().maximize();
       String link = "https://ilcarro.web.app/search";
        wd.register(new WDListener());
        wd.navigate().to(link);
        logger.info("Navigated to ---> " + link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        helperUser = new HelperUser(wd);

    }

   default void tearDown(){
//        pause(3000);
        wd.quit();
        logger.info("Test completed");
    }
}
