package requests;

import dto.deserialization.Activities;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ActivitiesRequests {
    static String activitiesBaseURI = "https://fakerestapi.azurewebsites.net/api/v1/Activities/";

    public static Response getActivity(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(activitiesBaseURI)
                .thenReturn();
    }

    public static Response getActivityByID(int id){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all()
                .when()
                .get(activitiesBaseURI + id)
                .thenReturn();
    }

    public  static  Response postActivity(Activities activities){
        return  RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(activities)
                .log().all()
                .when()
                .post(activitiesBaseURI)
                .thenReturn();
    }
}
