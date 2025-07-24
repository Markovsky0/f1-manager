package pl.f1manager.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Table(name = "engines", schema = "f1_manager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Engine {
    @Id
    @Column(name = "brand", length = 32)
    private String brand;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "performance", nullable = false)
    private short performance;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "reliability", nullable = false)
    private short reliability;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "fuel_usage", nullable = false)
    private short fuelUsage;
    @NotNull
    @Column(name = "price", nullable = false)
    private double price;
    @OneToMany(mappedBy = "engine", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Team> teams;
}
