package requests.reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserRequests {

    private static String baseURI = "https://reqres.in/api/";

    public static Response getUserById(String path){


        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(baseURI + path)
                .thenReturn();
    }


}
