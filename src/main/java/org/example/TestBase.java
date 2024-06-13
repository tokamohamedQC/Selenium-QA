package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.EventListener;
import java.util.Properties;

public class TestBase{
    public static WebDriver driver;
    public static WebDriverWait wait;

        public static Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\toka.ezzeldin\\IdeaProjects\\selenium_QAcart\\src\\com.freecrm.config\\config.properties");

    public TestBase() throws IOException {
        prop.load(fis);
    }


    public void init(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(prop.getProperty("URL"));
        wait = new WebDriverWait(driver, 10);
    }

    public void closePage() throws IOException {
        driver.quit();
    }

    public void screenShots(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\toka.ezzeldin\\IdeaProjects\\selenium_QAcart\\snapshots\\"+name+".png"));
    }

    public String readFile(int row, int column) throws Exception {
        File src = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx");
        FileInputStream testData = new FileInputStream(src);
        XSSFWorkbook x = new XSSFWorkbook(testData);
        XSSFSheet sheet = x.getSheetAt(0);
        String testDataInput = sheet.getRow(row).getCell(column).getStringCellValue();
        return testDataInput;
    }
}
