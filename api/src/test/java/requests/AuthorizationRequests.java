package requests;

import dto.deserialization.HerokuToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthorizationRequests {

    public static Response herokuappToken(HerokuToken herokuToken){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(herokuToken)
                .log().all()
                .when()
                .post("https://restful-booker.herokuapp.com/auth")
                .thenReturn();
    }
}
