package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.orangeHRM.LoginPage;

import static stepDefinitions.Hooks.driver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_valid_username_password(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @When("the user enters an invalid username and password")
    public void the_user_enters_an_invalid_username_and_password() {
        loginPage.enterUsername("Hello");
        loginPage.enterPassword("Hello123");
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("the user should not be logged in")
    public void the_user_should_not_be_logged_in() {
        Assert.assertTrue(loginPage.getLoginErrorMsg().isDisplayed());
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}
