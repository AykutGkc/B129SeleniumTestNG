package techproed.tests.day29_Lsteners_060523;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)

public class C02_ListenersTest2 {

    @Test(retryAnalyzer = techproed.utilities.Listeners.class) //Eger test fail olursa Listeners classinda ki Retry
                                                               // methodu sayesinde bir kez daha calisir.
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        Driver.getDriver().findElement(By.xpath("//*[class='asdfadsfasf']")); //Yanlis Locate aldik
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test2() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test3() {
        Driver.getDriver().get("blueRentACarUrl");
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("ayku@gmail.com",Keys.TAB,"1234",Keys.ENTER);
    }
}
