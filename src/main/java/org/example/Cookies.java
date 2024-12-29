package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Cookies {
    private final static String COOKIE_LINK_XPATH = "//a[contains(@href,'cookies')]";
    private final static String COOKIE_BTNS ="/../../../..//button";


    public static void main(String[] args) {
        WebDriver driver=null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            List<WebElement> cookieLink =
            driver.findElements(By.xpath((COOKIE_LINK_XPATH) ));
            if(!cookieLink.isEmpty()){
                List<WebElement> cookieFormBtns =
                        driver.findElements(By.xpath((COOKIE_LINK_XPATH+COOKIE_BTNS) ));
                cookieFormBtns.get(3).click();
            }
        }finally {
            if(driver !=null){
                driver.quit();
            }
        }
    }
}