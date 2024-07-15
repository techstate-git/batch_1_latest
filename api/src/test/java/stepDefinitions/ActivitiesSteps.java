package stepDefinitions;

import dto.deserialize.Activities;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

import static requests.ActivitiesRequest.*;
import static utilities.BodyBuilder.dueDateGenerator;

public class ActivitiesSteps {
    Activities activities = new Activities();

    @Given("the user is get activity by id = {int}")
    public void the_user_is_get_activity_by_id(int id){
//        getActivityByID(1).prettyPrint();

        Response response = getActivityByID(id);
        Activities activities = response.as(Activities.class);

        System.out.println(activities.getTitle());
        System.out.println(activities.getDueDate());
    }

    @Given("the user is get all activity list")
    public void the_user_is_get_all_activity_list(){
//        getActivities().prettyPrint();

        Response response = getActivities();
        List<Activities> activitiesList = response.as(new TypeRef<List<Activities>>() {});

        for (Activities activities : activitiesList) {
            System.out.println(activities.getTitle());
        }
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
