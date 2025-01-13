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
///////////////SERCHBOXES///////////////////
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
//////////////////BOXES IN CONTACT INFORMATION/////////////
    @Given("I search numberbox and enter {string}")
    public void searchNumberBox(String number){
        CucumberStorage.HOLDER.put("PhoneNumber",number);
        alloPage.searchNumberBox(CucumberStorage.HOLDER.get("PhoneNumber").toString());
    }
    @Given("I search box of first name and enter {string}")
    public void searchFirstNameBox(String name){
        CucumberStorage.HOLDER.put("FirstName",name);
        alloPage.searchFirstNameBox(CucumberStorage.HOLDER.get("FirstName").toString()) ;
    }
    @Given("I search box of last name and enter {string}")
    public void searchLastNameBox(String name){
        CucumberStorage.HOLDER.put("LastName",name);
        alloPage.searchLastNameBox(CucumberStorage.HOLDER.get("LastName").toString()) ;
    }

///////////////BUTTONS///////////////
@Given("I press searchbutton")
    public void enter(){
    alloPage.executeSearch();
}
@Given("I click the buy button")
public void clickToBuyButton(){
        alloPage.buyButton().click();
}
@Given("I click the buy now button")
public void clickToBuyNowButton(){
        alloPage.buyNowButton().get(0).click();
}
@Given("I click the delivery button")
public void clickToDeliveryButton(){
        alloPage.deliveryButton().get(0).click();
}
@Given("I click to catalog button")
    public void clickCatalogButton(){
        alloPage.getCatalogButton().get(0).click(); ;
    }
    @Given("I click to smartphones and phones")
    public void clickToSmartphonesButton(){
        alloPage.getSmartphonesButton().get(1).click();
    }
    @Given("I click to the Apple button")
    public void clickToAppleButton(){
        alloPage.getAppleButton().get(0).click();
    }
    /////////////BUTTONS FROM THE FILTER/////////////
    @Given("I choose the series of the phone")
    public void clickToSeriesButton(){
alloPage.getSeriesButton().get(5).click();
    }
    @Given("I click to IPhone 16 Pro Max check box")
    public void clickToProMaxCheckBox(){
        alloPage.getProMaxCheckBox2().click();
    }
    @Given("I filter from cheap to expensive")
    public void filterFromCheapToExpensive(){
        alloPage.getFilterChipest();
    }

    @Given("I click to title")
public void clickTitle() {
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
@Given("I print the name of chipest phone")
public void printName(){
        alloPage.printProductname();
}


@Given("I search phone price")
    public void getPrice(){
    CucumberStorage.HOLDER.put("PriceMob",alloPage.getPhonePrice().get(2).getText());
}
}
