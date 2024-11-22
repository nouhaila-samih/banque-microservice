package net.nouha.virementservice.feign;

import net.nouha.beneficiaireservice.repository.BeneficiaireRepository;
import net.nouha.virementservice.model.Beneficiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="beneficiaire-service")
public interface BeneficiaireRestClient {

    @GetMapping("/api/beneficiaires/{id}")
    Beneficiaire getBeneficiaireById(@PathVariable Long id);
    @GetMapping("/api/beneficiaires")
    PagedModel<Beneficiaire> getAllBeneficiaires();

}
