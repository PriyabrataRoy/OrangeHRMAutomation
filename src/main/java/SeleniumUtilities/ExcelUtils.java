package SeleniumUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(int row, int col) {

        String path =
                "src/test/resources/Excelsheets/Exceltestsheet.xlsx";

        try {
            FileInputStream fis = new FileInputStream(path);

            Workbook wb = new XSSFWorkbook(fis);

            Sheet sheet = wb.getSheetAt(0);

            String value =
                    sheet.getRow(row)
                         .getCell(col)
                         .getStringCellValue();

            wb.close();

            return value;

        } catch (Exception e) {

            e.printStackTrace();
            return "";
        }
    }
}