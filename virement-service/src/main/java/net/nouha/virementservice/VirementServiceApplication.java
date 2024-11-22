package net.nouha.virementservice;

import net.nouha.virementservice.entities.Virement;
import net.nouha.virementservice.enums.TypeVirement;
import net.nouha.virementservice.feign.BeneficiaireRestClient;
import net.nouha.virementservice.model.Beneficiaire;
import net.nouha.virementservice.repository.VirementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(VirementRepository virementRepository,
                                        BeneficiaireRestClient beneficiaireRestClient){
        return args -> {
            Collection<Beneficiaire> beneficiaires = beneficiaireRestClient.getAllBeneficiaires().getContent();

            beneficiaires.forEach(beneficiaire ->{
                virementRepository.save(Virement.builder().type(TypeVirement.Instantané).date(new Date()).idBeneficiaire(beneficiaire.getId()).description("CIH bank").montant(new Random().nextDouble(8000)).ribSource("1234567891230").build());
                virementRepository.save(Virement.builder().type(TypeVirement.Normal).date(new Date()).idBeneficiaire(beneficiaire.getId()).description("BP bank").montant(new Random().nextDouble(2000)).ribSource("7383838387230").build());
            });

        };
    }
}
