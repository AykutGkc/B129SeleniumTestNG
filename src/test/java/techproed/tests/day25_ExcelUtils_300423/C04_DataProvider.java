package techproed.tests.day25_ExcelUtils_300423;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.awt.dnd.DragGestureEvent;
import java.util.ConcurrentModificationException;

public class C04_DataProvider {



    /*
            -DataProvider bir cok veriyi test caselere loop kullanmadan aktarmak icin kullanilir.
            -TestNG'den gelen bir özelliktir. " boyutlu bir object Arry return eder.
            -DDT(Data Driven Testing) icin kullanilir.Yani birden azla veriyi test caselerde ayni anda kullanmak icin kullanilir.
            -Kullanimiicin @Test notasyonundan sonra parametre olarak dataProvider yazilir ve String bir isim
          belirtilir. Bu belirttigimiz isimle @DataProvider notasyonu ile bir method olusturulur.
             */



    /*
    Eger farkli bir test methodu icin ayni dataPRovider methodu kullanilacaksa
    @DataProvider(name="googleTest") seklinde @DataProvider notasyonundan sonra
    name parametresine yeni olusturulan methodun adini yazariz.
     */

    @Test(dataProvider = "urunler")
    public void testDataProvider(String data) { //DataProvider'daki verileri alabilmek icin
                                                // test methodumuza String bir parametre atamasi yapariz.

        System.out.println(data);

    }

    @DataProvider(name="googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}};
    }

    @Test(dataProvider = "googleTest")
    public void googleTest(String araclar) {
         //Google sayfasina gidiniz
        //Driver.getDriver().get("https://www.google.de/");
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));


        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"} araclari aratiniz
        GooglePage googlePage=new GooglePage();
        googlePage.cookiesKabul.click();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);

        //Her aramadan sonra sayfa resmi aliniz.
        ReusableMethods.fullScrennShot();
        ReusableMethods.waitWithThreadSleep(2);
        Driver.closeDriver();


    }
}
