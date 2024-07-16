package requests;

import dto.deserialization.Activities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ActivitiesRequest {
    static String activitiesBaseURL="https://fakerestapi.azurewebsites.net/api/v1/Activities/";
    public static Response getActivity(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(activitiesBaseURL)
                .thenReturn();

    }
    public static Response getActivityByID(int id) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(activitiesBaseURL + id)
                .thenReturn();
    }
    public static Response postActivity(Activities activities){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(activities)
                .log().all()
                .when()
                .post(activitiesBaseURL)
                .thenReturn();
    }
}
