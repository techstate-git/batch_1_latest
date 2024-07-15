package pages.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    @FindBy(linkText = "Admin")
    private WebElement adminMenuSection;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getAdminMenuSection() {
        return adminMenuSection;
    }
}
