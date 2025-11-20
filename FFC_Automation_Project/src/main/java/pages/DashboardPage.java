package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class DashboardPage {

    WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'Punch In')]")
    WebElement punchInBtn;

    @FindBy(className = "toast-message")
    WebElement toastMessage;

    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    WebElement customerMenu;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPunchIn() {
        punchInBtn.click();
    }

    public String getToastMessage() {
        return toastMessage.getText();
    }

    public void openCustomerPage() {
        customerMenu.click();
    }
}
