package net.nouha.beneficiaireservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.nouha.beneficiaireservice.enums.TypeBenef;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Beneficiaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String rib;
    @Enumerated(EnumType.STRING)
    private TypeBenef type;

}
