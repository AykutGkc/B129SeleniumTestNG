package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    //Exceldeki datalari baslik olmadan alabilmek icin 2 boyutlu bir Array method olusturalim

    public String[][] getDataArray(){
        String[][] data=new String[rowCount()][columnCount()];
        for (int i = 1; i <=rowCount() ; i++) {
            for (int j = 0; j <columnCount() ; j++) {
                String value=getCellData(i,j);
                data[i-1][j]=value;
            }
        }
        return data;
    }

    //==============Sutun isimlerini verir==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    //=========Deger, Satir, Sutun girindiginde, O satır ve sutuna girilen veriyi ekler===============//
    public void setCellData(String value, int rowNum, int colNum) {
        try {
            sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    Bu metot ustdeki metotla birlikde calisir. Overload eder. Parametreleri farklidir
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }


}
