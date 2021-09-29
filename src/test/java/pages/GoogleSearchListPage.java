package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchListPage extends PageBase{


    public static GoogleSearchListPage newInstance(WebDriver driver){
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(
                driver.findElement(By.id("result-stats"))
        ));

        return new GoogleSearchListPage(driver);
    }

    public GoogleSearchListPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchListPage CheckIfImOnThePage(){
        return this;
    }
}
