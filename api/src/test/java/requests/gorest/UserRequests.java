package requests.gorest;

import dto.deserialization.gorest.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserRequests {

    private static String baseURI = "https://gorest.co.in/public/v2/";

    public static Response getUsers(String path){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(baseURI + path)
                .andReturn();
    }

    public static Response createUser(String path, User user){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .auth().oauth2("5849e42834cab1752ea660e4a9e6e0a2f52387276a4d3dfb9e57350affdd171c")
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(baseURI + path)
                .andReturn();
    }





}
