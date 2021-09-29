package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends PageBase{


    @FindBy(name = "q")
    private WebElement eGoogleSearchBar;

    @FindBy(name = "btnK")
    private WebElement eGoogleSearchButton;

    public static GooglePage newInstance(WebDriver driver){
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(
                driver.findElement(By.name("q"))
        ));

        return new GooglePage(driver);
    }


    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GooglePage WriteInGoogleSearchBar(String text){
        WriteIn(eGoogleSearchBar, text);
        return this;
    }

    public GoogleSearchListPage clickOnSearch(){
        click(eGoogleSearchButton);
        return GoogleSearchListPage.newInstance(_);
    }

}
