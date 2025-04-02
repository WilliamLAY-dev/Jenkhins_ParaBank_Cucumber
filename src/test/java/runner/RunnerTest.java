package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features",
        glue="steps",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumberTestXray.json"},
        monochrome = true

)

public class RunnerTest {


}
