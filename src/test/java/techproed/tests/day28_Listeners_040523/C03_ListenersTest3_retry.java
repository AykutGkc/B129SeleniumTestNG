package techproed.tests.day28_Listeners_040523;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_ListenersTest3_retry {
    /*
    Test classiminda fail olma durumu olan bir testin tekrar calismasini istersek
    @Test notasyonundan sonra parametre olarak retryAnalyzer yazar ve olusturmus oldugumuz
    ListenersRetry classimizin yolunu belirtiriz.
     */
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test1() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test2() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandi");
    }
    @Test(retryAnalyzer = techproed.utilities.ListenersRetry.class)
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        //throw new NoSuchElementException();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("gadgagagfhgfd"));

    }
}
