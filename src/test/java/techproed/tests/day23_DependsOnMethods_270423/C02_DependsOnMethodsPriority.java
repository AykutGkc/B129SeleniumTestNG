package techproed.tests.day23_DependsOnMethods_270423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_DependsOnMethodsPriority {
    /*
    Bu classi DependsOnMEthod ve Priorirty arasindaki farki göstermek icin actik.
     */
    WebDriver driver;

    @Test
    public void amazonTest() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test (priority = 1)
    public void amazonTest2() {
        driver.get("https://www.amazon.com"); //Eger DependdsOnMethdos kullanmazsak  bu örnek icin NullPointerException hatasi aliriz.

    }

    @Test (priority = 2)
    public void amazontest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
