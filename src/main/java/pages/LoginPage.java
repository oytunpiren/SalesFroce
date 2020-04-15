package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  BasePage {


    @FindBy (id="ct100_MainContent_username")
    public WebElement userNmaeInputBoxElement;


    @FindBy(id="ct100_MainContent_password")
    public WebElement passwordInputBoxElement;



    public void login(String username, String password){
        userNmaeInputBoxElement.sendKeys(username);
        passwordInputBoxElement.sendKeys(password);
    }
}
