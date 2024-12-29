package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class TranningSelenium {
    private final static String xPathOfSearchBox = "//input[contains(@placeholder,'Пошук товарів')]";
    private final static String xPathOfTitle = "//a[contains(@class,'product-card__title')]";
    private final static String xPathOfPrice = "//span[contains(@class,'sum')]";
    public static void main(String[] args) {
        WebDriver driver = null;
        String phoneName="IPHONE 16";
        try{
            driver=new ChromeDriver();
            driver.get("https://allo.ua/");
            List<WebElement> searchBox=
                    driver.findElements(By.xpath(xPathOfSearchBox));
            searchBox.get(0).sendKeys(phoneName);
            searchBox.get(0).sendKeys(Keys.ENTER);
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            List<WebElement> searchTitle=
            webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfTitle),3));
            System.out.println(searchTitle.get(1).getText());
            System.out.println(searchTitle.size());
            searchTitle.get(0).click();
            List<WebElement> searchPrice=
            webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfPrice),1));
            System.out.println(searchPrice.get(3).getText()+" price of first phone");

        }finally{
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
