package techproed.tests.day23_DependsOnMethodsSoftAssertion_270423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_SoftAssertion {
    /*
    -SoftAssert kullanmak icin öncelikle bir obje olusturmamiz gerek.
    -Hard Assertionda bir dogrulama fail olursa testin calismasi durur.
    -Soft Assertion da assertAll() methodu ile testin farkli bölümlerinde softassert
    kullanarak dogrulama yapsak da testi istedigimiz yerde sonlandiririz.
     */




    SoftAssert softAssert;
    WebDriver driver;

    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ilk olarak olusturmus oldugumuz assetz methodlari ile dogrulama yapariz.
        //Son olarak objemi kullanarak assertAll() methodu kullanmam gerekir.
        softAssert=new SoftAssert();

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Url'in amazon.com.tr olup olmadigini dogrulayiniz.
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");
        //Burada hard assertion kullandik ve hata oldugu icin direk testi durdurdu.

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));
        System.out.println("Gercekte best icermiyor");

        //arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung icerip icermedigini test edin.
        WebElement sonuc= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonuc.getText().contains("samsung"));
        System.out.println("Bu assertion yanlis");
        System.out.println("Gercek sonuc Iphone olmali");
        softAssert.assertAll();
        System.out.println("Test sonuclandi");//Bunu yazdirmaz

    }
}
