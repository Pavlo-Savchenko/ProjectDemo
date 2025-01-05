package cucumber.steps.webSteps;

import io.cucumber.java.en.Given;
import org.example.pageObject.AlloPage;
import org.example.util.CucumberStorage;

public class WebSteps {

    public static AlloPage alloPage;

    @Given("I load allo page")
    public void iLoadAlloPage(){
    alloPage.loadPage();
}
@Given("I accept cookies if i need it")
    public void cookies(){
    alloPage.acceptCookiesIfPresent();
}
@Given("I search searchbox and enter {string}")
    public void search(String somePhone){
        CucumberStorage.HOLDER.put("searchValue",somePhone);
    alloPage.setSearchValue(CucumberStorage.HOLDER.get("searchValue").toString());
}
@Given ("We search searchbox and enter {string}")
public void searchValue(String someName){
        CucumberStorage.HOLDER.put("searchValue",someName );
    alloPage.setSearchValue(CucumberStorage.HOLDER.get("searchValue").toString());
}
@Given("I press searchbutton")
    public void enter(){
    alloPage.executeSearch();
}
@Given("I click to title")
public void clickTitle(){
alloPage.clickToTitle();
}



///////////////SEARCHING NAMES///////////////////
@Given("I search phone name")
public void getName(){
    CucumberStorage.HOLDER.put("NameMob",alloPage.getProductName().getText() );
}
@Given("I search product name")
public void getProductName(){
        CucumberStorage.HOLDER.put("ProductName",alloPage.getProductName().getText() );
}



@Given("I search phone price")
    public void getPrice(){
    CucumberStorage.HOLDER.put("PriceMob",alloPage.getPhonePrice().get(2).getText());
}
}
