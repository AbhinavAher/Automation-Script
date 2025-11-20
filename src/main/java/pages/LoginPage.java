package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-mobile")
    WebElement mobile;

    @FindBy(id = "login-password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterMobile(String user){
        mobile.sendKeys(user);
    }

    public void enterPassword(String pass){
        password.sendKeys(pass);
    }

    public void clickLogin(){
        loginBtn.click();
    }
}
