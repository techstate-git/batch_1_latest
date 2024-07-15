package pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebUtils;

import java.time.Duration;

public class SauceDemoLoginPage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public SauceDemoLoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebUtils.setDriver(driver);
    }

    public void enterUsername(String username){
        WebUtils.sendKeysToElement(userName, username, timeout);
    }

    public void enterPassword(String password){
        WebUtils.sendKeysToElement(passwordElement, password, timeout);
    }

    public void clickLoginButton(){
        WebUtils.clickElement(loginBtn, timeout);
    }
}
