package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.sauceDemo.SauceDemoLoginPage;

import static stepDefinitions.Hooks.driver;

public class SauceDemoLoginSteps {
    SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);

    @Given("the user is on the login page [SauceDemo]")
    public void the_user_is_on_the_login_page_sauce_demo() {
        driver.get("https://www.saucedemo.com/");
    }
    @When("the user enters a valid username and password [SauceDemo]")
    public void the_user_enters_a_valid_username_and_password_sauce_demo() {
        sauceDemoLoginPage.enterUsername("standard_user");
        sauceDemoLoginPage.enterPassword("secret_sauce");
    }
    @When("the user clicks the login button [SauceDemo]")
    public void the_user_clicks_the_login_button_sauce_demo() {
        sauceDemoLoginPage.clickLoginButton();
    }
    @Then("the user should be logged in [SauceDemo]")
    public void the_user_should_be_logged_in_sauce_demo() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual --->> " + actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("the user is login in using {string}")
    public void the_user_is_login_in_using_usernames(String username){
       sauceDemoLoginPage.enterUsername(username);
    }

    @And("the user is enter password")
    public void the_user_is_enter_password(){
        sauceDemoLoginPage.enterPassword("secret_sauce");
    }
}













