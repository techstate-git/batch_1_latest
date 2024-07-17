package requests;

import dto.deserialization.BookingByID;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingRequests {
    private static String bookingBaseURI = "https://restful-booker.herokuapp.com/booking/";

    public static Response getBookingIDs(){
        return RestAssured.given()
                .log().all()
                .when()
                .get(bookingBaseURI)
                .thenReturn();
    }

    public static Response getBookingByID(int id){
        return RestAssured.given()
                .log().all()
                .when()
                .get(bookingBaseURI + id)
                .thenReturn();
    }

    public static Response updateBooking(String token, int id, BookingByID bookingByID){
        return RestAssured.given()
                .header("Cookie", "token=" + token)
                .body(bookingByID)
                .log().all()
                .when()
                .put(bookingBaseURI + id)
                .thenReturn();

    }













}
