package techproed.tests.day22_Annotation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class C03_Priority {
    /*
    TestNG test methodlarini isim sirasina (alfabetik) göre calistirir. Eger isim siralamasinin
    disinda bir siralama ile calismasini isterseniz o zaman test methodlarina öncelik(priority)
    tanimlayabiliriz.
    Priority kücükten büyüye dogru calisir.Eger bir test methoduna priority atanmamissa default olarak
    priority=0 kabul edilir.
     */
    WebDriver driver;
    @Test(priority = -3)
    public void techproedTest() {
        driver.get("https://www.techproeducation.com/");
    }

    @Test(priority = -1)
    public void amazonTest() {
        driver.get("https://www.amazon.com/");
    }

    @Test(priority = -2)
    public void facebookTest() {
        driver.get("https://www.facebook.com/");

    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
