package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GooglePage;
import utilities.Driver;
import utilities.SeleniumUtilies;

import java.util.List;
import java.util.Map;
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

    @Then("user create a account")
    public void user_create_a_account(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        googlePage.searchBox.sendKeys(data.get(0).get(0));

    }

    @Then("verify")
    public void verify() {
        Assert.assertTrue(true);
    }



    }
