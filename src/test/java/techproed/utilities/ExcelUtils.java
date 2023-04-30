package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    Workbook workbook;
    Sheet sheet;
    String path;

    // Constuctor:Excel Path'ine ve Excel'Deki sayfaya ulasmak icin 2 parametreli constructor olusturduk.
    public ExcelUtils(String path, String sheetName) throws FileNotFoundException {
        this.path=path;

        try {
            FileInputStream fis=new FileInputStream(path);
            workbook= WorkbookFactory.create(fis);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //GetCellData: Satir ve sütun sayilari girildiginde o hücredeki veriyi return eder.
    public String getCellData(int rowNum, int columnNum){
        Cell cell=sheet.getRow(rowNum).getCell(columnNum);
        return cell.toString();
    }

    //Exceldeki satir sayisini return eder.
    public int rowCount(){
        return sheet.getLastRowNum();
    }

    //Exceldeki sütun sayisini return eder.
    public int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }
}
