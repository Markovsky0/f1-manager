package pl.f1manager.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Table(name = "tyres", schema = "f1_manager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tyre {
    @Id
    @Size(min = 1, max = 32)
    private String brand;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "performance_dry", nullable = false)
    private short performanceDry;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "performance_wet", nullable = false)
    private short performanceWet;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "durability", nullable = false)
    private short durability;
    @NotNull
    @Min(1) @Max(10)
    @Column(name = "warmup_time", nullable = false)
    private short warmupTime;
    @NotNull
    @Min(10) @Max(40)
    @Column(name = "optimal_temp", nullable = false)
    private short optimalTemp;
    @NotNull
    @Column(name = "price", nullable = false)
    private double price;
    @OneToMany(mappedBy = "tyre", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Team> teams;
}
