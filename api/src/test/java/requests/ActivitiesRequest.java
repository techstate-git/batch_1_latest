package requests;

import dto.deserialize.Activities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ActivitiesRequest {
    static String baseURI = "https://fakerestapi.azurewebsites.net/";

    // Method to perform GET request to the specified endpoint
    public static Response getActivityByID(int id) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(baseURI + "api/v1/Activities/" + id)
                .thenReturn();
    }

    // Method to perform GET request to the specified endpoint
    public static Response getActivities() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(baseURI + "api/v1/Activities")
                .thenReturn();
    }

    public static Response postActivity(Activities activities) {

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(activities)
                .log().all()
                .when()
                .post(baseURI + "api/v1/Activities").thenReturn();
    }
}
