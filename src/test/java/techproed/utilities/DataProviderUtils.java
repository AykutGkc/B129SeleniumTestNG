package techproed.utilities;

import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;

public class DataProviderUtils {
    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","IcAnadolu","06"},{"Izmir","Ege","35"},{"Diyarbakir","Dogu","21"}};
    }

    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Aykut","123456789"},{"Gül","1242513512"},{"Erol","3253253253"}};
    }

    @DataProvider
    public Object[][] blueRental() throws FileNotFoundException {
        ExcelUtils excelUtils=new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");
        return excelUtils.getDataArray();
    }
}
