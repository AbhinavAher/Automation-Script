package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.DashboardPage;

public class PunchInTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testffc.nimapinfotech.com/");

        LoginPage lp = new LoginPage(driver);
        lp.enterMobile("9519519519");
        lp.enterPassword("12345678");
        lp.clickLogin();
    }

    @Test
    public void verifyPunchInToast() throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        dp.clickPunchIn();

        Thread.sleep(2000);
        String message = dp.getToastMessage();

        Assert.assertEquals(message, "PunchIn Successfully");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
