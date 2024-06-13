package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;


public class LoginPageTest extends TestBase{

    public LoginPageTest() throws IOException{
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
    }

    @AfterMethod
    public void close() throws IOException {
        closePage();
    }

    @Test (priority = 1)
    public void titleTest(Method method) throws IOException {

        String expected = "Free CRM software for customer relationship management, sales, and support.";
        System.out.println(driver.getTitle());
        Assert.assertEquals(expected, driver.getTitle());
        screenShots(method.getName());
    }

    @Test (priority = 2)
    public void urlTest(Method method) throws IOException{
        String expected = "https://classic.freecrm.com/index.html";
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(expected, driver.getCurrentUrl());
        screenShots(method.getName());
    }


    @Test (priority = 3)
    public void imgTest(Method method) throws IOException{
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//img[@src='https://classic.freecrm.com/img/logo@2x.png']"))));
        WebElement image = driver.findElement(By.xpath("//img[@src='https://classic.freecrm.com/img/logo@2x.png']"));
        boolean expected = true;
        Assert.assertEquals(expected, image.isDisplayed());
        screenShots(method.getName());
    }

    @Test (priority = 4)
    public void loginTest(Method method) throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//img[@src='https://classic.freecrm.com/img/logo@2x.png']"))));
        WebElement emailInput = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        emailInput.sendKeys(readFile(0,0));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordInput.sendKeys(readFile(1,0));
        WebElement login = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        login.click();
        System.out.println(driver.getCurrentUrl());
        screenShots(method.getName());

    }

//    @DataProvider
//    public Object[][] Mydata(){
//        Object[][] data = new Object[1][2];
//        data[0][0] = "TMohamed";
//        data[0][1] = "4UigY@RtVy3UtVk";
//
//
//        return data;
//
//    }


}
