package net.nouha.virementservice.web;

import net.nouha.virementservice.entities.Virement;
import net.nouha.virementservice.feign.BeneficiaireRestClient;
import net.nouha.virementservice.repository.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VirementRestController {
    @Autowired
    private BeneficiaireRestClient beneficiaireRestClient;
    @Autowired
    private VirementRepository virementRepository;
    @GetMapping(path = "/virements/{id}")
    public Virement getVirement(@PathVariable Long id){
        Virement virement = virementRepository.findById(id).get();
        virement.setBeneficiaire(beneficiaireRestClient.getBeneficiaireById(virement.getIdBeneficiaire()));
        return virement;
    }
}
