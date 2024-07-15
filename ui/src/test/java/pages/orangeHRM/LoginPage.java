package pages.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebUtils;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[.='Invalid credentials']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebUtils.setDriver(driver);
    }

    public void enterUsername(String username) {
        WebUtils.sendKeysToElement(usernameField, username, timeout);
    }

    public void enterPassword(String password) {
        WebUtils.sendKeysToElement(passwordField, password, timeout);
    }

    public void clickLoginButton(){
        WebUtils.clickElement(loginButton, timeout);
    }

    public WebElement getLoginErrorMsg() {
        return WebUtils.waitForElement(errorMessage, timeout);
    }
}
