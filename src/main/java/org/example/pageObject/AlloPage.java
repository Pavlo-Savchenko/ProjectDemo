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
    private final static String COOKIE_BTNS = "/../../../..//button";

    private final static String xPathOfSearchBox = "//input[contains(@id,'search-form__input')]";
    private final static String xPathOfTitle = "//img[contains(@itemprop,'image')]";
    private final static String xPathOfPrice = "//span[contains(@class,'sum')]";
    private final static String xPathOfPhoneName = "//h1[contains(@class,'p-view__header-title')]";
    private final static String xPathOfSearchButton = "//button[contains(@class,'search-form__submit-button')]";
    private final static String xPathOfProductName = "//a[contains(@class,'product-card__title')]";
    private final static String xPathOfBuyButton = "//button[contains(@id,'product-buy-button')]";
    private final static String xPathOfBuyNowButton = "//button[contains(@class,'order-now')]";
    private final static String xPathOfDeliveryButton = "//button[contains(@class,'a-button a-button--block a-button--lg a-button--primary')]";
    private final static String xPathOfCatalogButton = "//div[contains(@class,'ct-button')]";
    private final static String xPathOfSmartphonesButton = "//li[contains(@class,'mm__item')]";
    private final static String xPathOfAppleButton = "//a[contains(@class,'portal-card__link')]";
    private final static String xPathOfSeriesButton = "//h3[contains(@class,'header-title')]";
    private final static String xPathOfProMaxCheckBox2 = "//a[contains(@data-id,'223336')]";
    private final static String xPathOfContactBoxes = "//input";


    public AlloPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("about:blank");
        driver.get("https://allo.ua/");
    }

    public void acceptCookiesIfPresent() {
        List<WebElement> cookieLink =
                driver.findElements(By.xpath((COOKIE_LINK_XPATH)));
        if (!cookieLink.isEmpty()) {
            List<WebElement> cookieFormBtns =
                    driver.findElements(By.xpath((COOKIE_LINK_XPATH + COOKIE_BTNS)));
            cookieFormBtns.get(3).click();
        }
    }

    public void setSearchValue(String value) {
        List<WebElement> searchBox =
                driver.findElements(By.xpath(xPathOfSearchBox));
        searchBox.get(0).sendKeys(value);
    }

    public void executeSearch() {
        List<WebElement> searchButton =
                driver.findElements(By.xpath(xPathOfSearchButton));
        searchButton.get(0).click();
    }

    public void clickToTitle() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> phonesList =
                driverWait.until(ExpectedConditions.
                        numberOfElementsToBeMoreThan(By.xpath(xPathOfTitle), 3));
        phonesList.get(0).click();
    }

    public List<WebElement> getPhonePrice() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> phonePriceList =
                driverWait.until(ExpectedConditions.
                        numberOfElementsToBeMoreThan(By.xpath(xPathOfPrice), 1));
        return phonePriceList;
    }

    public WebElement getProductName() {

        WebElement name = driver.findElement(By.xpath(xPathOfPhoneName));
        return name;
    }
    public void printProductname(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elements = driverWait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath(xPathOfProductName),3 ));
        System.out.println(elements.get(0).getText());
    }
    ///////////////////BUTTONS///////////////
    public WebElement buyButton() {
        WebElement button = driver.findElement(By.xpath(xPathOfBuyButton));
        return button;
    }

    public List<WebElement> buyNowButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> button = webDriverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath(xPathOfBuyNowButton), 1));
        return button;
    }
    public List<WebElement> deliveryButton() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> button = webDriverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath(xPathOfDeliveryButton), 1));
        return button;
        }
        public List<WebElement> getCatalogButton(){
        List<WebElement> button = driver.findElements(By.xpath(xPathOfCatalogButton));
        return button;
    }
    public List<WebElement> getSmartphonesButton(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> button = driverWait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath(xPathOfSmartphonesButton),3 ));
        return button;
    }
    public List<WebElement> getAppleButton() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> button = driverWait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath(xPathOfAppleButton), 5));
       return button;
    }
    /////////////BUTTONS FROM THE FILTER/////////////
    public List<WebElement> getSeriesButton(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> button = driverWait.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath(xPathOfSeriesButton),5 ) );
        return button;
    }
    public WebElement getProMaxCheckBox2() {
        WebElement button = driver.findElement(By.xpath(xPathOfProMaxCheckBox2) );
        return button;
    }
    public void getFilterChipest(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> elements = driverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//a[contains(@data-id,'serija_smartfony')]"),2) );
        WebDriverWait driverWait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> button = driverWait1.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//div[contains(@class,'sort-by__select')]"),1 ));
        button.get(0).click();
        WebDriverWait driverWait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> button2 = driverWait2.until(ExpectedConditions.
                numberOfElementsToBeMoreThan(By.xpath("//li[contains(@class,'sort-by__item')]"),3));
        if(button2.isEmpty()){
            button2.get(0).click();
        }
    }
    /////////ENTER CONTACT INFORMATION//////////////
    public void searchNumberBox(String value){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> numberBox = webDriverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath(xPathOfContactBoxes),3 ));
        numberBox.get(0).sendKeys(value);
    }
    public void searchFirstNameBox(String value){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> numberBox = webDriverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath(xPathOfContactBoxes),3 ));
        numberBox.get(1).sendKeys(value);
    }
    public void searchLastNameBox(String value){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> numberBox = webDriverWait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath(xPathOfContactBoxes),3 ));
        numberBox.get(2).sendKeys(value);
    }
}