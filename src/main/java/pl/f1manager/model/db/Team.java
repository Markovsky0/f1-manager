package pl.f1manager.model.db;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "teams", schema = "f1_manager")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 64)
    @NotNull
    private String name;
    @Column(name = "country", length = 32)
    @NotNull
    private String country;
    @NotNull
    private String primaryColor;
    @NotNull
    private String secondaryColor;
    @ManyToOne
    @JoinColumn(name = "engine_brand")
    private Engine engine;
    @ManyToOne
    @JoinColumn(name = "tyre_brand")
    private Tyre tyre;
    //todo fabryki, składy kierowców, lista sponsorów
}
