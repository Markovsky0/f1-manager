package pl.f1manager.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.f1manager.model.enums.DriverStatus;
import pl.f1manager.model.enums.Gender;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DriverDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String nationality;
    @NotNull
    @Min(18)
    private short age;
    @NotNull
    private Gender gender;
    @NotNull
    private DriverStatus status = DriverStatus.INACTIVE;
    @NotNull
    @Min(1) @Max(100)
    private short quickness;
    @NotNull
    @Min(1) @Max(100)
    private short focus;
    @NotNull
    @Min(1) @Max(100)
    private short overtaking;
    @NotNull
    @Min(1) @Max(100)
    private short drivingInWet;
    @NotNull
    @Min(1) @Max(100)
    private short experience;
    @NotNull
    @Min(1) @Max(100)
    private short technicalInsight;
    @NotNull
    @Min(1) @Max(100)
    private short agility;
    @NotNull
    @Min(1) @Max(100)
    private short popularity;
    @NotNull
    @Min(1) @Max(5)
    private short morale;
    private short overall;
}
