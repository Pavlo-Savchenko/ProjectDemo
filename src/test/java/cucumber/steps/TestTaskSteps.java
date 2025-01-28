package cucumber.steps;

import io.cucumber.java.en.Given;
import org.example.pageObject.SwegLabsPage;
import org.example.util.CucumberStorage;
import org.testng.Assert;

public class TestTaskSteps {

    public static SwegLabsPage swegLab;

    @Given("I load SwegLabs page")
    public void loadPage(){
        swegLab.loadPage();
    }
@Given("I put my name {string}")
    public void putName(String myName){
    CucumberStorage.HOLDER.put("MyNameValue",myName );
    swegLab.putMyNeme(CucumberStorage.HOLDER.get("MyNameValue").toString());
}
@Given("I put my password {string}")
public void putPassword(String myPass){
    CucumberStorage.HOLDER.put("MyPassValue",myPass );
    swegLab.putMyPassword(CucumberStorage.HOLDER.get("MyPassValue").toString());
}
@Given("I press the login button")
    public void enter(){
        swegLab.enter();
}
@Given("I sort the goods")
    public void sort(){
swegLab.sort();
}
@Given("I get title name")
public void getTitleName(){
    CucumberStorage.HOLDER.put("TitleName",swegLab.getTitleName().get(4).getText());
    System.out.println(CucumberStorage.HOLDER.get("TitleName").toString());
}
    @Given("I get title price")
    public void getTitlePrice(){
        CucumberStorage.HOLDER.put("TitlePrice",swegLab.getTitlePrice().get(4).getText());
        System.out.println(CucumberStorage.HOLDER.get("TitlePrice").toString());
    }
    @Given("I click to Title")
    public void clickToTitle(){
swegLab.clickTitle();
    }
    @Given("I get name in details")
    public void getDetailsName(){
        CucumberStorage.HOLDER.put("DetailsName",swegLab.getDetailsName().get(0).getText());
    }
    @Given("I get price in details")
    public void getDetailsPrice(){
        CucumberStorage.HOLDER.put("DetailsPrice",swegLab.getDetailsPrice().get(0).getText());
    }
    @Given("I compare values")
    public void compareValues(){
        Assert.assertEquals(CucumberStorage.HOLDER.get("TitleName").toString().toUpperCase(),
                CucumberStorage.HOLDER.get("DetailsName").toString().toUpperCase(),"THE VALUES OF NAME ARE NOT EQUAL");
        Assert.assertEquals(CucumberStorage.HOLDER.get("TitlePrice").toString().toUpperCase(),
                CucumberStorage.HOLDER.get("DetailsPrice").toString().toUpperCase(),"THE VALUES OF PRICE ARE NOT EQUAL");
    }
    @Given("I add to cart")
    public void addToCard(){
swegLab.clickToCardButton();
    }
@Given("I get counter value")
    public void getValue(){
    CucumberStorage.HOLDER.put("CounterValue",swegLab.getCounterValue().get(0).getText());
}
@Given("I compare counter value and {string}")
    public void compareCounterValue(String value){
        CucumberStorage.HOLDER.put("ComparingValue",value);
    Assert.assertEquals(CucumberStorage.HOLDER.get("ComparingValue").toString(),
            CucumberStorage.HOLDER.get("CounterValue").toString(),"OUR PRODUCT IS NOT ADDED");
}
@Given("I go to the cart")
    public void clickToCart(){
swegLab.goToTheCard();
}
@Given("I get name in the cart")
    public void getNameInTheCart(){
        CucumberStorage.HOLDER.put("NameInTheCart",swegLab.getNameInTheCart().get(0).getText());
    System.out.println(CucumberStorage.HOLDER.get("NameInTheCart").toString());
}
    @Given("I get price in the cart")
    public void getPriceInTheCart(){
        CucumberStorage.HOLDER.put("PriceInTheCart",swegLab.getPriceInTheCart().get(0).getText());
        System.out.println(CucumberStorage.HOLDER.get("PriceInTheCart").toString());
    }
    @Given("I compare values in the cart")
    public void compareValuesInTheCart(){
        Assert.assertEquals(CucumberStorage.HOLDER.get("TitleName").toString().toUpperCase(),
                CucumberStorage.HOLDER.get("NameInTheCart").toString().toUpperCase(),
                "THE VALUES OF NAME ARE NOT EQUAL IN THE CART");
        Assert.assertEquals(CucumberStorage.HOLDER.get("TitlePrice").toString().toUpperCase(),
                CucumberStorage.HOLDER.get("PriceInTheCart").toString().toUpperCase(),
                "THE VALUES OF PRICE ARE NOT EQUAL IN THE CART");
    }
}
