package net.nouha.virementservice.repository;

import net.nouha.virementservice.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepository extends JpaRepository<Virement,Long> {
}
