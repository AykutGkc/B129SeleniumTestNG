package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    Driver classindaki temel mantik extends yöntemi ile degil yani TestBase classina extends etmek yerine
    driver clasindan static methodlar kullanarak driver olustururuz. Static oldugu icin class ismi ile heryerden
    methoda ulasabilecegiz.
     */

    /*
    Singleton Pattern:Tekli kullanim kalibi
        Bir classtan obje olusturulmasinin önüne gecilmesi icin kullanilan ifade.
        Bir class'tan obje olusturmanin önüne gecebilmek icin default constructor'in kullanimini engellemek icin
    private Access Modifier kullanarak bir constructor olustururuz.
     */
    private Driver(){

    }

    static WebDriver driver;

    public static WebDriver getDriver() {
        /*
        Driver'i her cagirdiginda yeni bir pencere acilmasinin önüne gecmek icin
        if blogu icinde eger driver'a deger atanmamissa deger ata, eger deger atanmissa driver'i ayni
        sayfada RETURN et.Bunun icin  sadece yapmamiz gereken ---> if(driver==null) kullanmak
         */
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origins=*"));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//Driver'a değer atanmışşsa
            driver.close();
            driver = null;
        } 
    }

    public static void quitDriver() {
        if (driver != null) { //Driver'A deger atanmissa
            driver.quit();
            driver = null;
        }

    }


}
