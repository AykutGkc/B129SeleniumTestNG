package techproed.tests.day23_DependsOnMethodsSoftAssertion_270423;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C04_DriverTest {

    @Test
    public void driverTest1() {
        Driver.getDriver().get("https://www.techproeducation.com/");
        Driver.getDriver().get("https://www.amazon.com/");
        Driver.getDriver().get("https://www.facebook.com/");
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        System.out.println(ConfigReader.getProperty("username"));
        System.out.println(ConfigReader.getProperty("password"));
    }
}
