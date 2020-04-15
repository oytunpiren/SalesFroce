package step_definations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginStepDefinations {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        Thread.sleep(1000);
    }


    @Then("user logs in")
    public void user_logs_in() {
        System.out.println("user logs in");
        String username = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");
       loginPage.login(username, password);
    }



}
