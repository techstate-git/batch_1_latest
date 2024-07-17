package dto.deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingByID {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additionalneeds;
    private BookingDates bookingdates;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }
}
