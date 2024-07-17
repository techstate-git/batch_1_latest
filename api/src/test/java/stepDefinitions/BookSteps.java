package stepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.deserialization.BookingByID;
import dto.deserialization.BookingIDs;
import dto.deserialization.HerokuToken;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.sql.SQLOutput;
import java.util.List;

import static requests.AuthorizationRequests.herokuappToken;
import static requests.BookingRequests.*;

public class BookSteps {
    HerokuToken herokuToken = new HerokuToken();
    BookingByID bookingByID = new BookingByID();

    private static String generatedToken;
    private static int id;

    @Given("the user is able to generate token")
    public void generateToken(){
        herokuToken.setUsername("admin");
        herokuToken.setPassword("password123");

        Response response = herokuappToken(herokuToken);
        HerokuToken herokuTokenResponse = response.as(HerokuToken.class);
        generatedToken = herokuTokenResponse.getToken();

        System.out.println("Generated token: " + generatedToken);
    }

    @Given("the user is successfully retrieve Booking by ID")
    public void retrieve_Booking_by_ID(){
        List<BookingIDs> bookingIDs = getBookingIDs().as(new TypeRef<List<BookingIDs>>() {});
        id = bookingIDs.get(0).getBookingid();

        getBookingByID(id).prettyPrint();
    }

    @Then("the user is able to update the Booking")
    public void update_the_booking(){
        bookingByID.setFirstname("Beksultan");
        bookingByID.setLastname("Ismatov");
        bookingByID.setTotalprice(300);
        bookingByID.setDepositpaid(true);
        bookingByID.setAdditionalneeds("Breakfast");

        BookingByID.BookingDates bookingDates = new BookingByID.BookingDates();
        bookingDates.setCheckin("2023-07-01");
        bookingDates.setCheckout("2023-07-10");
        bookingByID.setBookingdates(bookingDates);

        updateBooking(generatedToken, id, bookingByID).prettyPrint();
    }
}
