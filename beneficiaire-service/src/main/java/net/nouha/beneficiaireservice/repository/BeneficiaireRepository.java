package net.nouha.beneficiaireservice.repository;

import net.nouha.beneficiaireservice.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire,Long> {
}
