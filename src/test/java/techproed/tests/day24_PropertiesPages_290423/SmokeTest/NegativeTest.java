package techproed.tests.day24_PropertiesPages_290423.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class NegativeTest {
    @Test(groups = "smoke")
    public void test1() {
        /*
        Description:
        Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        Acceptance Criteria
        Customer email: fake@bluerentalcars.com
        Customer password: fakepass
        Error:
        User with email fake@bluerentalcars.com not found
         */

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        Reporter.log("BlueRental Sayfasina gidildi.");
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        Reporter.log("Login butonuna tiklandi");
        blueRentalPage.login.click();

        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"),
                Keys.TAB,ConfigReader.getProperty("fakepass"));
        Reporter.log("Email ve password girildi");
        blueRentalPage.login2.click();
        Reporter.log("Tekrar login butonuna tiklandi");
        ReusableMethods.waitWithThreadSleep(3);
        ReusableMethods.fullScrennShot("fakeMail");
        Reporter.log("Sayfa resmi alindi");
        Assert.assertTrue(blueRentalPage.hataMesaji.isDisplayed());
        Reporter.log("Dogrulama yapildi");
        Driver.closeDriver();
        Reporter.log("Sayfa kapatildi");
    }
}
