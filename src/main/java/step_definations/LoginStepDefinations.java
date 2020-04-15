package step_definations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefinations {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        Thread.sleep(1000);
    }


    @Then("user logs in")
    public void user_logs_in() {

    }



}
