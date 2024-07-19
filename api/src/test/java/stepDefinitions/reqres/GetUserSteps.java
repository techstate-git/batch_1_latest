package stepDefinitions.reqres;

import dto.deserialization.reqres.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import requests.reqres.UserRequests;

public class GetUserSteps {

    private String endpoint;
    private Response response;


    @Given("the user prepares a url endpoint with id {string}")
    public void theUserPreparesAUrlEndpointWithId(String path) {
        endpoint = path;
    }

    @When("the user sends a request")
    public void theUserSendsARequest() {
        response = UserRequests.getUserById(endpoint);
    }

    @Then("the user should get a correct response")
    public void theUserShouldGetUser() {
        User user = response.as(User.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(1, user.getData().getId());
        Assert.assertEquals("George", user.getData().getFirst_name());
        Assert.assertEquals("Bluth", user.getData().getLast_name());
        Assert.assertEquals("george.bluth@reqres.in", user.getData().getEmail());
    }
}
