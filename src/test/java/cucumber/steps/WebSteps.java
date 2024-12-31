package cucumber.steps;

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
@Given("I press searchbutton")
    public void enter(){
    alloPage.executeSearch();
}
@Given("I click to phone title")
public void clickTitle(){
alloPage.clickToTitle();
}
@Given("I search phone name")
public void getName(){
    CucumberStorage.HOLDER.put("NameMob",alloPage.getPhoneName().getText() );
}
@Given("I search phone price")
    public void getPrice(){
    CucumberStorage.HOLDER.put("PriceMob",alloPage.getPhonePrice().get(2).getText());
}
}
