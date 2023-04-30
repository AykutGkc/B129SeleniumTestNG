package techproed.tests.day24_PropertiesPages_290423;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PageKullanimi {
    @Test
    public void test1() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));
        /*
        Yukarida ki adres icin 20 adet test methodu olusturursak sonrasinda yukaridaki url'de bir degisiklik oldugunda
      bütün test methodlarindan tek tek url düzeltmek yerine bir kez properties dosyamdan url düzeltiriz ve bu bizim
      icin daha jizli daha düzenli ve daha kolay olur.
         */

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //Driver.getDriver().findElement();
        OpenSourcePage openSourcePage=new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.dashboard.isDisplayed());
        Driver.closeDriver();

    }
}
