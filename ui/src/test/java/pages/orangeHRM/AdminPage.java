package pages.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WebUtils;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;
    private Duration timeout = Duration.ofSeconds(10);


    @FindBy(xpath = "(//form//input)[1]")
    private WebElement searchBox;

    @FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]/div")
    private WebElement userRole;

    @FindBy(xpath = "(//form//input)[2]")
    private WebElement employeeName;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    private WebElement status;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
    private WebElement recordsFound;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        WebUtils.setDriver(driver);
    }

    public void enterUsername(String username){
        searchBox.sendKeys(username);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public void setSearchBox(WebElement searchBox) {
        this.searchBox = searchBox;
    }

    public WebElement getUserRole() {
        return userRole;
    }

    public void setUserRole(WebElement userRole) {
        this.userRole = userRole;
    }

    public WebElement getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(WebElement employeeName) {
        this.employeeName = employeeName;
    }

    public WebElement getStatus() {
        return status;
    }

    public void setStatus(WebElement status) {
        this.status = status;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(WebElement searchBtn) {
        this.searchBtn = searchBtn;
    }

    public WebElement getRecordsFound() {
        return recordsFound;
    }

    public void setRecordsFound(WebElement recordsFound) {
        this.recordsFound = recordsFound;
    }
}
