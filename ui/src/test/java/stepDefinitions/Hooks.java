package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.WebUtils;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebUtils.setDriver(driver);
        System.out.println("Driver setup completed successfully");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        if (driver != null) {
            driver.quit();
            System.out.println("Driver teardown completed successfully");
        }
    }
}
