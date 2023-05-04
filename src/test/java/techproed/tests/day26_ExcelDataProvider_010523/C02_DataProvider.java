package techproed.tests.day26_ExcelDataProvider_010523;

import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class C02_DataProvider {


    @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
    public void test1(String ad, String bolge, String plaka) {
        System.out.println(ad + " " + bolge + " " + plaka);
    }

    @Test(dataProvider = "kullanicilar", dataProviderClass = DataProviderUtils.class)
    public void test2(String username, String password) {
        System.out.println(username + " " + password);
    }
    /*
    Yukaridaki örnekler gibi blueRentalCar sayfasina login olunuz
    Her data icin  login oldugunuzu dogrulayiniz
    NOT:configuration.properties dosyasindaki verileri kullaniniz
     */

}
