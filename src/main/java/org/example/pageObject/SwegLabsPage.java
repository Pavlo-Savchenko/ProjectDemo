package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SwegLabsPage {

    private final WebDriver driver;
    private final static String URL = "https://www.saucedemo.com/";
    private final static String xPathOfLoginBoxes = "//input";
    private final static String xPathOfSort = "//option";
    private final static String xPathOfTitleName = "//div[contains(@class,'inventory_item_name ')]";
    private final static String xPathOfTitlePrice = "//div[contains(@class,'inventory_item_price')]";
    private final static String xPathOfClickTitle = "//div[contains(@class,'inventory_item_name ')]";
    private final static String xPathOfDetailsName = "//div[contains(@class,'inventory_details_name large_size')]";
    private final static String xPathOfDetailsPrice = "//div[contains(@class,'inventory_details_price')]";
    private final static String xPathOfCardButton = "//button[contains(@class,'btn btn_primary btn_small btn_inventory')]";
    private final static String xPathOfCounterValue = "//span[contains(@class,'shopping_cart_badge')]";
    private final static String xPathOfCard = "//a[contains(@class,'shopping_cart_link')]";
    private final static String xPathOfNameInTheCart = "//div[contains(@class,'inventory_item_name')]";
    private final static String xPathOfPriceInTheCart = "//div[contains(@class,'inventory_item_price')]";


    public SwegLabsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(URL);
    }

    public void putMyNeme(String value) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> boxes = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfLoginBoxes), 2));
        boxes.get(0).sendKeys(value);
    }

    public void putMyPassword(String value) {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> boxes = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfLoginBoxes), 2));
        boxes.get(1).sendKeys(value);
    }

    public void enter() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> boxes = driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfLoginBoxes), 2));
        boxes.get(2).click();
    }

    public void sort() {
        driver.findElement(By.className("product_sort_container")).click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> sort = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfSort), 4));
        sort.get(3).click();
    }

    public List<WebElement> getTitleName() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> titleNames = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfTitleName), 6));
        return titleNames;
    }

    public List<WebElement> getTitlePrice() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> titleCosts = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfTitlePrice), 6));
        return titleCosts;
    }

    public void clickTitle() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> titleNames = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfClickTitle), 6));
        titleNames.get(4).click();
    }

    public List<WebElement> getDetailsName() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> DetailsName = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfDetailsName),1));
        return DetailsName;
    }
    public List<WebElement> getDetailsPrice() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> detailsPrice = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfDetailsPrice),1));
        return detailsPrice;
    }
    public void clickToCardButton(){
        driver.findElements(By.xpath(xPathOfCardButton)).get(0).click();
    }
    public List<WebElement> getCounterValue(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> counterValue = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfCounterValue),1 ));
        return counterValue;
    }
    public void goToTheCard(){
      driver.findElements(By.xpath(xPathOfCard)).get(0).click();
    }
    public List<WebElement> getNameInTheCart() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> nameInTheCart = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfNameInTheCart),1));
        return nameInTheCart;
    }
    public List<WebElement> getPriceInTheCart() {
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> priceInTheCart = driverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPathOfPriceInTheCart),1));
        return priceInTheCart;
    }
}
