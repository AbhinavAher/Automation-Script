package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.DashboardPage;
import pages.AddCustomerPage;

public class AddCustomerTest {

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

    @Test(dataProvider = "customerData")
    public void addCustomerTest(String name, String email) throws InterruptedException {
        DashboardPage dp = new DashboardPage(driver);
        dp.openCustomerPage();

        AddCustomerPage ac = new AddCustomerPage(driver);
        ac.addCustomer(name, email);

        Thread.sleep(2000);
        Assert.assertTrue(ac.getToastMessage().contains("Customer Added"));
    }

    @DataProvider
    public Object[][] customerData(){
        return new Object[][]{
            {"Automation User", "autoUser@gmail.com"}
        };
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
