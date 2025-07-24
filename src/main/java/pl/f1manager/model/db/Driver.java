package pl.f1manager.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Formula;
import pl.f1manager.model.enums.DriverStatus;
import pl.f1manager.model.enums.Gender;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "drivers", schema = "f1_manager")
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 32)
    private String firstName;
    @NotNull
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @NotNull
    @Column(name = "nationality", nullable = false, length = 32)
    private String nationality;
    @NotNull
    @Column(name = "age", nullable = false)
    @Min(18)
    private short age;
    @NotNull
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DriverStatus status = DriverStatus.INACTIVE;
    @NotNull
    @Column(name = "quickness", nullable = false)
    @Min(1) @Max(100)
    private short quickness;
    @NotNull
    @Column(name="focus", nullable = false)
    @Min(1) @Max(100)
    private short focus;
    @NotNull
    @Column(name="overtaking", nullable = false)
    @Min(1) @Max(100)
    private short overtaking;
    @NotNull
    @Column(name="driving_in_wet", nullable = false)
    @Min(1) @Max(100)
    private short drivingInWet;
    @NotNull
    @Column(name = "experience", nullable = false)
    @Min(1) @Max(100)
    private short experience;
    @NotNull
    @Min(1) @Max(100)
    @Column(name = "technical_insight", nullable = false)
    private short technicalInsight;
    @NotNull
    @Min(1) @Max(100)
    @Column(name = "agility", nullable = false)
    private short agility;
    @NotNull
    @Min(1) @Max(100)
    @Column(name = "popularity", nullable = false)
    private short popularity;
    @NotNull
    @Min(1) @Max(5)
    @Column(name="morale", nullable = false)
    private short morale;
//    @NotNull
//    @Column(name="overall", nullable = false)
//    @Min(1) @Max(100)
    @Formula("(quickness + focus + overtaking + driving_in_wet + experience + technical_insight + agility + popularity) / 8")
    private short overall;

}
