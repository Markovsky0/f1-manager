package pl.f1manager.model.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.f1manager.model.enums.DriverStatus;

@Data
@Getter
@Setter
public class DriverSearchCriteria {
    private String firstName = null;
    private String lastName = null;
    private short minAge;
    private short maxAge;
    private DriverStatus status;
    private short minOverall;
    private short maxOverall;
}
