package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AddCustomerPage {

    WebDriver driver;

    @FindBy(id = "customer-name")
    WebElement customerName;

    @FindBy(id = "customer-email")
    WebElement customerEmail;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerBtn;

    @FindBy(className = "toast-message")
    WebElement toastMessage;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addCustomer(String name, String email){
        customerName.sendKeys(name);
        customerEmail.sendKeys(email);
        addCustomerBtn.click();
    }

    public String getToastMessage() {
        return toastMessage.getText();
    }
}
