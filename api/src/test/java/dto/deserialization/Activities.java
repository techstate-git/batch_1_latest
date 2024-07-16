package dto.deserialization;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activities {
    private int id;
    private String title;
    private String dueDate;
    private boolean completed;
}
