package pages.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebUtils;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']/parent::a/parent::div/following-sibling::div//button")
    private WebElement SauceLabsBackpackItem;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebUtils.setDriver(driver);
    }

    public void clickOnItem(List<String> items, String targetItem) {
        for (String item : items) {
            if (item.equals(targetItem)) {
                WebElement element = driver.findElement(By.xpath("//div[.='" + item + "']/parent::a/parent::div/following-sibling::div//button"));
                WebUtils.clickElement(element, timeout);
                break; // Exit the loop once the item is clicked
            }
        }
    }
}
