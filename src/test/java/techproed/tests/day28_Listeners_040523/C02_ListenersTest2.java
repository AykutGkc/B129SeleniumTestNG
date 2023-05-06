package techproed.tests.day28_Listeners_040523;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.NoSuchElementException;

public class C02_ListenersTest2 {
    @Test
    public void test1() {
        System.out.println("PASSED");
        Assert.assertTrue(true);
        Assert.assertEquals(2,2);
    }
    @Test
    public void test2() {
        System.out.println("FAILED");
        Assert.assertTrue(false);
    }

    @Test
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandi");
    }
    @Test
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        //throw new NoSuchElementException();

        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("gadgagagfhgfd"));

    }
}
