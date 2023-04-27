package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*
    Driver classindaki temel mantik extends yöntemi ile degil yani TestBase classina extends etmek yerine
    driver clasindan static methodlar kullanarak driver olustururuz. Static oldugu icin class ismi ile heryerden
    methoda ulasabilecegiz.
     */

    static WebDriver driver;
    public static WebDriver getDriver(){
        /*
        Driver'i her cagirdiginda yeni bir pencere acilmasinin önüne gecmek icin
        if blogu icinde eger driver'a deger atanmamissa deger ata, eger deger atanmissa driver'i ayni
        sayfada RETURN et.Bunun icin  sadece yapmamiz gereken ---> if(driver==null) kullanmak
         */
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        driver.close();
    }



}
