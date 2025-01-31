package cucumber.steps;

import cucumber.steps.webSteps.WebSteps;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.pageObject.AlloPage;
import org.example.pageObject.SwegLabsPage;
import org.example.util.CucumberStorage;
import org.openqa.selenium.WebDriver;
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
                driver = org.example.driver.WedDriverFactory.getDriver();
                WebSteps.alloPage = new AlloPage(driver);
                //TestTaskSteps.swegLab=new SwegLabsPage(driver );
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