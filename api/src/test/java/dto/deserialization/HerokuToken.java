package dto.deserialization;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HerokuToken {
    private String username;
    private String password;
    private String token;
}
