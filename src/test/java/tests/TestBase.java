package tests;

import config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @BeforeSuite
    public void BeforeSuite(){}

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod(){
        try{

            Browser.setUpDriver("chrome");
            driver = Browser.getBrowser();
            driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get("http://www.google.com");
        }
        catch (Exception e){
            System.out.println("El Test Ha Fallado por\n" + e.getMessage());
        }

    }

    @AfterMethod
    public void AfterMethod(){
        if(driver != null) driver.quit();
    }

    @AfterSuite
    public void AfterSuite(){}
}
