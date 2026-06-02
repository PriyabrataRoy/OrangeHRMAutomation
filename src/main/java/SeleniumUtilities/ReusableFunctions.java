package SeleniumUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {
	
	public WebDriver driver;
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
	
	public ReusableFunctions(WebDriver driver) {
		this.driver=driver;
	}
	
	//add explicit wait time to the element
	public void waitTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Insert text in the element
	public void insertText(WebElement element, String Value) {
		waitTime(element);
		element.sendKeys(Value);
	}
	
	//Click the element 
	public void clickElement(WebElement element) {
		waitTime(element);
		element.click();
	}
	
	//add implicit wait to the element
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//Takes the screenshot of the output
	public void TakeScreenshot(String Filename) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path = "src/test/resources/Screenshots/" + Filename + ".png";
	    try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	
	//get the excel file using path and sheet name
	public void setExcel(String excelPath, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Excel load karne me error: " + e.getMessage());
        }
    }
    
    // 2. Total Row Count
    public int getRowCount() {
        if (sheet != null) {
            return sheet.getPhysicalNumberOfRows();
        }
        return 0;
    }
    
    // 3. read the data from cell
    public String getCellData(int rowNum, int colNum) {
        try {
            return sheet.getRow(rowNum).getCell(colNum).toString();
        } catch (Exception e) {
            return ""; // if cell empty then return blank
        }
    }
	
}
