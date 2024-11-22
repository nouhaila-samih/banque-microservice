package net.nouha.virementservice.model;

import lombok.Getter;
import lombok.Setter;
import net.nouha.beneficiaireservice.enums.TypeBenef;

@Getter @Setter
public class Beneficiaire {
    private Long id;
    private String nom;
    private String prenom;
    private String rib;
    private TypeBenef type;
}
