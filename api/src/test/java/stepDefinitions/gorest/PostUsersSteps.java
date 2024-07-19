package stepDefinitions.gorest;

import dto.deserialization.gorest.User;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import requests.gorest.UserRequests;

public class PostUsersSteps {

    private String endpoint;
    private Response response;

    @Given("the user is preparing a post request {string}")
    public void theUserIsPreparingAPostRequest(String path) {
        endpoint = path;
    }

    @When("the user sends a request to create a user")
    public void theUserSendsARequestToCreateAUser() {
        User user = new User();
        user.setName("Zhanarbek");
        user.setEmail("zhanarbek1@yahoo.com");
        user.setGender("male");
        user.setStatus("active");

        response = UserRequests.createUser(endpoint, user);
    }

    @Then("the user should get created user as a response")
    public void theUserShouldGetCreatedUserAsAResponse() {
        Assert.assertEquals(201, response.statusCode());
    }
}
