package techproed.tests.day26_ExcelDataProvider_010523;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.*;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class C03_DataProviderExcel {
    @Test
    public void test1() throws FileNotFoundException {
        ExcelUtils ExcelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");
        System.out.println(Arrays.deepToString(ExcelUtils.getDataArray()));
    }

    @Test(dataProvider = "blueRental",dataProviderClass = DataProviderUtils.class)
    public void test2(String email,String password) {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.login.click(); //Login butonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.waitWithThreadSleep(3);
        Driver.closeDriver();
    }
    /*
    TESTLERİMİZ: TEST PACKAGE ALTINDA
    LOCATELERİMİZ:PAGES PACKAGE ALTINDA
    AYARLAMALARI YAPTIĞIMIZ VE METHODLAR OLUŞTURDUĞUMUZ CLASSLAR UTILITIES ALTINDA
     */


}
