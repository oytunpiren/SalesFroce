package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GooglePage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class SeleniumUtilies {


    public static void imlicitWait(int second) {
        Driver.getDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    public static void expilictWait(WebElement element) {
        WebDriverWait w = new WebDriverWait(Driver.getDriver(), 10);
        w.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fluentWait (){
        Wait <WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
    }


}
