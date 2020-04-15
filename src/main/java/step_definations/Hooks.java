package step_definations;

import io.cucumber.java.After;
import utilities.Driver;

public class Hooks {

    @After
    public void tearDwon(){
        System.out.println("Closing browser");
        Driver.getDriver().quit();
    }
}
