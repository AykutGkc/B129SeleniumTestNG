package techproed.tests.day25_ExcelUtils_300423;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.FileNotFoundException;
import java.security.Key;

public class C03BlueRentalExcelTest2 {

    @Test
    public void test1() throws FileNotFoundException {
        /*
        Excel dosyamizdaki tüm email ve passwortler ile
        BlueRentalCAr sayfasina gidip Login olalim
         */
        ExcelUtils excelUtils=new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        //sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage=new BlueRentalPage();


        //Bir loop olusturup excel dosyasindaki tüm verileri girdirelim
        for (int i = 1; i <= excelUtils.rowCount() ; i++) { //i'yi 1 den baslattik cünkü veriler birinci satirdan baasliyor.
            String mail=excelUtils.getCellData(i,0);
            String password=excelUtils.getCellData(i,1);
            System.out.println(mail+" || " +password);
            blueRentalPage.login.click();
            ReusableMethods.waitWithThreadSleep(3);
            blueRentalPage.email.sendKeys(mail, Keys.TAB,password, Keys.ENTER);
            Assert.assertTrue(blueRentalPage.verify.isDisplayed());
            ReusableMethods.waitWithThreadSleep(3);
            blueRentalPage.login3.click();
            ReusableMethods.waitWithThreadSleep(3);
            blueRentalPage.logout.click();
            ReusableMethods.waitWithThreadSleep(3);
            blueRentalPage.ok.click();
            ReusableMethods.waitWithThreadSleep(3);




        }
        Driver.closeDriver();
    }
}
