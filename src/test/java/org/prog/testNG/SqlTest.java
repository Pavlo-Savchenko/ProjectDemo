package org.prog.testNG;

import org.example.pageObject.AlloPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;
import java.time.Duration;
import java.util.List;

public class SqlTest {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private WebDriver driver;

    private String value = "IPhone 16";
    private final static String COOKIE_LINK_XPATH = "//a[contains(@href,'cookies')]";
    private final static String COOKIE_BTNS ="/../../../..//button";
    private final static String xPathOfSearchBox = "//input[contains(@id,'search-form__input')]";
    private final static String xPathOfTitle = "//img[contains(@itemprop,'image')]";
    private final static String xPathOfPrice = "//span[contains(@class,'sum')]";
    private final static String xPathOfNamePhone = "//a[contains(@title,'Apple iPhone 16')]";
    private final static String INSERT_PATTERN = "INSERT INTO IPhoneTable (NamePhone,PrisePhone)" +
            "VALUES ('%s', '%s')";

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Test
    public void insertFromDbTest() throws SQLException, ClassNotFoundException {
        connectionDb();
        try{
            String name = getFirstPhoneName().getFirst().getText();
            String price = getPricePhone().get(2).getText();
                statement.execute(String.format(INSERT_PATTERN,name,price));
        }finally{
            closeConnection();
        }
    }
    private void connectionDb() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db","user","password");
        statement = connection.createStatement();
    }
    private void closeConnection() throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }
    public List<WebElement>  getFirstPhoneName(){
        driver.get("https://allo.ua/");
        List<WebElement> cookieLink =
                driver.findElements(By.xpath((COOKIE_LINK_XPATH) ));
        if(!cookieLink.isEmpty()){
            List<WebElement> cookieFormBtns =
                    driver.findElements(By.xpath((COOKIE_LINK_XPATH+COOKIE_BTNS) ));
            cookieFormBtns.get(3).click();
        }
        List<WebElement> searchBox=
                driver.findElements(By.xpath(xPathOfSearchBox));
        searchBox.get(0).sendKeys(value);
        searchBox.get(0).sendKeys(Keys.ENTER);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> phoneNameList=
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfNamePhone),3));
        return phoneNameList;
    }
    public List<WebElement> getPricePhone(){
        driver.get("https://allo.ua/");
        List<WebElement> cookieLink =
                driver.findElements(By.xpath((COOKIE_LINK_XPATH) ));
        if(!cookieLink.isEmpty()){
            List<WebElement> cookieFormBtns =
                    driver.findElements(By.xpath((COOKIE_LINK_XPATH+COOKIE_BTNS) ));
            cookieFormBtns.get(3).click();
        }
        List<WebElement> searchBox=
                driver.findElements(By.xpath(xPathOfSearchBox));
        searchBox.get(0).sendKeys(value);
        searchBox.get(0).sendKeys(Keys.ENTER);
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> phonesList =
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfTitle),3 ));
        phonesList.get(0).click();
        List<WebElement> phonePriceList =
                driverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(xPathOfPrice),1 ));
        return phonePriceList;
    }
}
