package cucumber.steps.webSteps.webCheck;

import io.cucumber.java.en.Given;
import org.example.util.CucumberStorage;
import org.testng.Assert;

public class CheckForReproducibility {
    @Given("I compare the name with value")
    public void compareValues(){
        if(!CucumberStorage.HOLDER.get("ProductName").toString().toUpperCase().
                contains(CucumberStorage.HOLDER.get("searchValue").toString().toUpperCase()) ){
            Assert.assertFalse(CucumberStorage.HOLDER.get("ProductName").toString().toUpperCase().
                    contains(CucumberStorage.HOLDER.get("searchValue").toString().toUpperCase()), "There is no such value in products name");
        }else{
            System.out.println("We have this text in the product name");
        }
    }
}
