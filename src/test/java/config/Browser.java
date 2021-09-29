package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver _driver;

    public static void setUpDriver(String browser) throws NoMatchingBrowser {
        switch (browser){
            case "chrome":
                ChromeOptions copts = new ChromeOptions();
                copts.addArguments("incognito");

                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver(copts);

                break;
            default:
                throw new NoMatchingBrowser("The browser:" + browser + ". Is not available");
        }
    }

    public static WebDriver getBrowser(){
        if(_driver == null){
            throw new NullPointerException("Driver has not been setup");
        }
        return _driver;
    }
}

class NoMatchingBrowser extends Exception{
    NoMatchingBrowser(String message){
        super(message);
    }
}
