package cucumber.steps;

import cucumber.steps.webSteps.WebSteps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.pageObject.AlloPage;
import org.example.util.CucumberStorage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        })

public class CucumberRunner extends AbstractTestNGCucumberTests {
public WebDriver driver;

        @BeforeSuite
        public void inet(){
                driver = new ChromeDriver();
                WebSteps.alloPage = new AlloPage(driver);
        }
        @BeforeMethod
        public void clearStorage(){
                CucumberStorage.HOLDER.clear();
        }
        @AfterSuite
        public void tearDown(){
                driver.quit();
        }
}