package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
glue = "step_defonations",
features = "src/main/resources/features"

)


public class CukesRunner {





}
