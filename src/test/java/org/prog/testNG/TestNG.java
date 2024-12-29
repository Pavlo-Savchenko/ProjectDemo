package org.prog.testNG;

import org.example.pageObject.AlloPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class TestNG {

    private  WebDriver driver;
    private AlloPage alloPage;

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        alloPage = new AlloPage(driver);
    }

    @BeforeMethod
    public void reloadGooglePage(){
        alloPage.loadPage();
        alloPage.acceptCookiesIfPresent();
    }

    @AfterSuite
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Test(dataProvider = "phoneNames")
    public void TestAllo(String phoneName){
        alloPage.setSearchValue(phoneName);
        alloPage.executeSearch();
        System.out.println(alloPage.getPhonePrice().get(3).getText());
    }

    @DataProvider
    public Object[][] phoneNames(){
        return new Object[][]{
                {"IPhone 16"},
                {"Moto Edge 50"}
        };
    }
}
