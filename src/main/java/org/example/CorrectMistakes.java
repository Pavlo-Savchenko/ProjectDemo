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

public class CorrectMistakes {
    private final static String xPathOfSearchBox = "//input[contains(@id,'search-form__input')]";
    private final static String xPathOfTitle = "//img[contains(@itemprop,'image')]";
    private final static String xPathOfPrice = "//span[contains(@class,'sum')]";
    private final static String phoneName = "Iphone 16";

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver=new ChromeDriver();
            driver.get("https://allo.ua/");

            List<WebElement> searchBox=
                    driver.findElements(By.xpath(xPathOfSearchBox) );
            searchBox.get(0).sendKeys(phoneName);
            searchBox.get(0).sendKeys(Keys.ENTER);

            WebDriverWait driverWait = new WebDriverWait(driver,Duration.ofSeconds(10) );

            List<WebElement> phonesList =
                    driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfTitle),3 ));
            System.out.println(phonesList.size() );
            phonesList.get(0).click();

            List<WebElement> phonePriceList =
                   driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfPrice),1 ));
            System.out.println(phonePriceList.get(3).getText());

        }finally{
            if(driver!=null){
                driver.quit();
            }
        }
    }
}
