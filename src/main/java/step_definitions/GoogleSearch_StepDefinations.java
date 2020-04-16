package step_definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GooglePage;
import utilities.Driver;
import utilities.SeleniumUtilies;

import java.util.concurrent.TimeUnit;

public class GoogleSearch_StepDefinations {

    GooglePage googlePage = new GooglePage();


    @Given("User go to website")
    public void user_go_to_website() {
        Driver.getDriver().get("https://www.google.com/");

    }

    @Then("user search {string}")
    public void user_search(String string) {
        googlePage.searchBox.sendKeys(string, Keys.ENTER);




    }
}
