package stepDefinitions.gorest;

import dto.deserialization.gorest.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import requests.gorest.UserRequests;

public class GetUsersSteps {

    private String endpoint;
    private Response response;


    @Given("the user is preparing a url endpoint {string}")
    public void theUserIsPreparingAUrlEndpoint(String path) {
        endpoint = path;
    }

    @When("the user sends a request to server")
    public void theUserSendsARequestToServer() {
        response = UserRequests.getUsers(endpoint);
    }

    @Then("the user should get collection of users")
    public void theUserShouldGetCollectionOfUsers() {
        User[] user = response.as(User[].class);
        Assert.assertEquals(10, user.length);
    }
}
