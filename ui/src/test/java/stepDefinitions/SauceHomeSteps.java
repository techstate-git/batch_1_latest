package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.sauceDemo.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static stepDefinitions.Hooks.driver;


public class SauceHomeSteps {
    HomePage homePage = new HomePage(driver);
    private List<String> listOfItems = new ArrayList<>();

    @Then("user is adding to cart items below")
    public void add_items_to_cart(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            listOfItems.add(row.get("items"));
        }
        System.out.println(listOfItems);
    }
    @Then("user clicks on {string}")
    public void user_clicks_on_item(String targetItem) {
        homePage.clickOnItem(listOfItems, targetItem);
    }
}
