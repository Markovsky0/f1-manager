package pl.f1manager.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pl.f1manager.model.enums.SponsorCategory;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sponsors", schema = "f1_manager")
public class Sponsor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "brand", nullable = false, length = 32)
    private String brand;
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name", nullable = false, length = 32)
    private String country;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private SponsorCategory sponsorCategory = SponsorCategory.PLACEHOLDER;
    @NotNull
    @Column(name = "signature_amount", nullable = false)
    private double signatureAmount;
    @NotNull
    @Column(name = "amount_per_race", nullable = false)
    private double amountPerRace;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "reputation", nullable = false)
    private short reputation;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "patience", nullable = false)
    private short patience;
}
