package techproed.tests.day25_ExcelUtils_300423;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

import java.io.FileNotFoundException;

public class C02_BlueRentralExcelTest1 {
    @Test
    public void excelTest() throws FileNotFoundException {

        /*
        Eger bir veriyi(datayi) properties dosyasindan almak istiyorsak, ConfigReader classindan getProperty()
      methodunu kullanarak .properties dosyamiza girdigimiz key degerini belirtiriz ve bize bu key degerinin
      value'sunu döndürür.
        Eger bir veriyi(datayi) Excel dosyasindan almak isteyorsak, olusturmus oldugumuz ExcelUtils class'indaki
      Methodlari kullanarak istedigimiz veriyi alabiliriz.
         */
        ExcelUtils excelUtils=new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email=excelUtils.getCellData(1,0);
        String password=excelUtils.getCellData(1,1);

        System.out.println(email+"||" + password);

        //BlueRentalCar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));

        //Excel dosyamizdan aldigimiz ilk email ve password ile sayfaya login olalim.
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.login.click(); //login butonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        //Excel'den aldigimiz verileri sendKeys() methodu ile gönderdik.

        //Login oldugumuzu dogrulayim

        Assert.assertTrue(blueRentalPage.verify.isDisplayed());

    }
}
