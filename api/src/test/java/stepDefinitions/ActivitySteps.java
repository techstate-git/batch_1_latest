package stepDefinitions;

import dto.deserialization.Activities;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static requests.ActivitiesRequests.*;
import static utilities.BodyBuilder.dueDateGenerator;

public class ActivitySteps {
    Activities activities = new Activities();

    @Given("the user is get activities")
    public void the_user_is_get_activities(){
        Response response = getActivity();
        response.prettyPrint();

        List<Activities> activitiesList = response.as(new TypeRef<List<Activities>>() {});

        for (Activities activities : activitiesList){
            System.out.println(activities.getTitle());
        }
    }

    @Given("the user is get activity by id = {int}")
    public void the_user_is_get_activity_by_id(int id){
        Response response = getActivityByID(id); // Store endpoint response
        response.prettyPrint(); // Print our response

        Activities activities = response.as(Activities.class); // extract response to class

        System.out.println(activities.getTitle()); // Print title

        String activityTitle = activities.getTitle();
        String expectedID = String.valueOf(activities.getId());
        Assert.assertTrue(activityTitle.contains(expectedID));
    }

    @Given("the user is created activity with id = {int}")
    public void the_user_is_created_activity_with_id(int id){
        activities.setId(id);
    }

    @And("the title is = {string}")
    public void the_title_is(String title){
        activities.setTitle(title);
    }

    @And("the due date is = {int} days")
    public void the_due_date_is(int days){
        activities.setDueDate(dueDateGenerator(days));
    }

    @And("activity is completed = {booleanType}")
    public void activity_is_completed(boolean isCompleted){
        activities.setCompleted(isCompleted);
    }

    @Then("the user is creating activity using parameters above")
    public void the_user_creating_activity(){
        postActivity(activities).prettyPrint();
    }

    @ParameterType("true|false")
    public boolean booleanType(String value) {
        return Boolean.parseBoolean(value);
    }
}
