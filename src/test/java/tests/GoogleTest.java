package tests;

import org.testng.annotations.Test;
import pages.GooglePage;

public class GoogleTest extends TestBase{

    @Test
    public void TestInicial(){
        GooglePage.newInstance(driver)
                .WriteInGoogleSearchBar("Hola mundo")
                .clickOnSearch()
                .CheckIfImOnThePage();
    }
}
