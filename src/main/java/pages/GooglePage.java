package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage{


    @FindBy (name = "q")
    public WebElement searchBox;

    @FindBy (xpath = "(//input[@name='btnK'])[2]")
    public WebElement clickButton;




}
