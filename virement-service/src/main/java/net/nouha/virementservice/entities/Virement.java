package net.nouha.virementservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.nouha.virementservice.enums.TypeVirement;
import net.nouha.virementservice.model.Beneficiaire;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Virement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idBeneficiaire;
    private String ribSource;
    private double montant;
    private String description;
    private Date date;
    private TypeVirement type;
    @Transient
    private Beneficiaire beneficiaire;


}
