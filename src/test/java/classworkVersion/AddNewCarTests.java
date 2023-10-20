package classworkVersion;

import manager.NGListener;
import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class AddNewCarTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(isLogged() == false){
            login(getEmail(),getPassword()
            );

        }
    }
    @Test(groups = {"positive", "smoke"})
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-" + i) //have problems in firefox
                .price("150")
                .about("New car")
                .build();

        openCarForm();
        fillCarForm(car);
        logger.info("addNewCarPositive starts with : "+ car.getLocation() + " , " + car.getManufacture()
                + " , " + car.getModel()+ " , " + car.getYear()+ " , " + car.getFuel() + " , "+
                car.getSeats()+ " , " + car.getCarClass()+ " , "+ car.getCarRegNumber()+ " , "+car.getPrice()+ " , "+
                car.getAbout());
        pause(5000);
    }
//    @Test
//    public void addNewCarNegativeLocation(){
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        Car car = Car.builder()
//                .location("qqqqqqqqqq")
//                .manufacture("KIA")
//                .model("Sportage")
//                .year("2020")
//                .fuel("Petrol")
//                .seats("5")
//                .carClass("B")
//                .carRegNumber("100-200-" + i)
//                .price("150")
//                .about("New car")
//                .build();
//
//        openCarForm();
//        fillCarForm(car);
//        logger.info(" Test addNewCarPositive starts with : "+ car.getLocation() + " , " + car.getManufacture()
//                + " , " + car.getModel()+ " , " + car.getYear()+ " , " + car.getFuel() + " , "+
//                car.getSeats()+ " , " + car.getCarClass()+ " , "+ car.getCarRegNumber()+ " , "+car.getPrice()+ " , "+
//                car.getAbout());
//        Assert.assertTrue(isElementPresent(By.xpath("//*[. = ' Wrong address ']")));
//        pause(5000);
//    }
}
