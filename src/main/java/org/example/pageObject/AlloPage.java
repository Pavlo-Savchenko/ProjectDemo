package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlloPage {

    private final WebDriver driver;

    private final static String COOKIE_LINK_XPATH = "//a[contains(@href,'cookies')]";
    private final static String COOKIE_BTNS ="/../../../..//button";

    private final static String xPathOfSearchBox = "//input[contains(@id,'search-form__input')]";
    private final static String xPathOfTitle = "//img[contains(@itemprop,'image')]";
    private final static String xPathOfPrice = "//span[contains(@class,'sum')]";
    private final static String xPathOfPhoneName = "//h1[contains(@class,'p-view__header-title')]";
    private final static String xPathOfSearchButton = "//button[contains(@class,'search-form__submit-button')]";


    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage(){
        driver.get("about:blank");
        driver.get("https://allo.ua/");
    }
    public void acceptCookiesIfPresent(){
        List<WebElement> cookieLink =
                driver.findElements(By.xpath((COOKIE_LINK_XPATH) ));
        if(!cookieLink.isEmpty()){
            List<WebElement> cookieFormBtns =
                    driver.findElements(By.xpath((COOKIE_LINK_XPATH+COOKIE_BTNS) ));
            cookieFormBtns.get(3).click();
        }
    }
public void setSearchValue(String value){
    List<WebElement> searchBox=
            driver.findElements(By.xpath(xPathOfSearchBox));
    searchBox.get(0).sendKeys(value );
}
public void executeSearch(){
    List<WebElement> searchButton=
            driver.findElements(By.xpath(xPathOfSearchButton));
    searchButton.get(0).click();
}
public void clickToTitle(){
    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    List<WebElement> phonesList =
            driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfTitle),3 ));
    phonesList.get(0).click();
}
public List<WebElement> getPhonePrice(){
    WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    List<WebElement> phonePriceList =
            driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfPrice),1 ));
    return phonePriceList;
}
public WebElement getPhoneName(){

    WebElement phoneName = driver.findElement(By.xpath(xPathOfPhoneName) );
    return phoneName;
    }
}
