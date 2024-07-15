package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.orangeHRM.AdminPage;
import pages.orangeHRM.HomePage;

public class AdminSteps {

    private AdminPage adminPage = new AdminPage(Hooks.driver);
    private HomePage homePage = new HomePage(Hooks.driver);

    @And("the admin enters username in the search field {string}")
    public void theAdminEntersUsername(String u) {
        adminPage.enterUsername(u);
    }

    @And("the admin clicks searchBox")
    public void theAdminClicksSearchBox(){
        adminPage.getSearchBtn().click();
    }

    @Then("there should be record found")
    public void thereShouldBeRecordFound() {
        System.out.println(adminPage.getRecordsFound().getText());
    }

    @When("the user clicks admin menu section")
    public void theUserClicksAdminMenuSection() {
        homePage.getAdminMenuSection().click();
    }
}
