package techproed.tests.day25_ExcelUtils_300423;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

import java.io.FileNotFoundException;

public class C01_ExcelTest1 {

    @Test
    public void ExcelTest1() throws FileNotFoundException {
        String path="src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa="customer_info";
        ExcelUtils excelUtils=new ExcelUtils(path,sayfa);
        System.out.println("excelUtils.getCellData(1,0) = " + excelUtils.getCellData(1, 0));
        String eMail=excelUtils.getCellData(1,0);
        String password=excelUtils.getCellData(1,1);
        System.out.println(eMail+"||"+password);

    }
}
