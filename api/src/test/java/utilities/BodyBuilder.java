package utilities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class BodyBuilder {
    public static String dueDateGenerator(int days){
        // Define the pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        // Generate current date and time in UTC
        LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
        currentDateTime.format(formatter);

        // Add customized days to current date
        LocalDateTime newDateTime = currentDateTime.plus(days, ChronoUnit.DAYS);
        String newDateTimeFormatted = newDateTime.format(formatter);

        return newDateTimeFormatted;
    }
}
