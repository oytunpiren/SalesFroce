package step_definitions;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Driver;

import java.security.Key;
import java.util.List;

public class Calender {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();
        WebElement from = driver.findElement(By.id("travel_from"));
        from.sendKeys("chicago o");
        Thread.sleep(2000);
    from.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

    WebElement to = driver.findElement(By.id("travel_to"));
    to.sendKeys("miami");
    Thread.sleep(2000);
    to.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);

driver.findElement(By.id("travel_date")).click();

        while(!driver.findElement(By.xpath("(//div[@class='datepicker-days']//th)[2]")).getText().contains("September")){
            driver.findElement(By.xpath("(//div[@class='datepicker-days']//th)[3]")).click();
        }

List<WebElement> days = driver.findElements(By.xpath("//td[@class='day']"));
int count = days.size();

for (int i=0; i< count;i++){
String text = driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();
if(text.equalsIgnoreCase("29")){
    driver.findElements(By.xpath("//td[@class='day']")).get(i).click();
}
}


    }

}
