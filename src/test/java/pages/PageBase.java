package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

    WebDriver _;
    WebDriverWait wait;

    public PageBase(WebDriver driver){
        _ = driver;
        PageFactory.initElements(_,this);

        wait = new WebDriverWait(_, 30);
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void click(WebElement e){
        wait.until(ExpectedConditions.visibilityOf(e));
        e.click();
    }

    public void WriteIn(WebElement e, String text){
        wait.until(ExpectedConditions.visibilityOf(e));
        e.sendKeys(text);
    }
}
