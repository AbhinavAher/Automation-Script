package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testffc.nimapinfotech.com/");
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String mobile, String password){
        LoginPage lp = new LoginPage(driver);
        lp.enterMobile(mobile);
        lp.enterPassword(password);
        lp.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @DataProvider
    public Object[][] loginData(){
        return new Object[][]{
            {"9519519519", "12345678"}
        };
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
