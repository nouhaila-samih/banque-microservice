package net.nouha.beneficiaireservice;

import net.nouha.beneficiaireservice.entities.Beneficiaire;
import net.nouha.beneficiaireservice.enums.TypeBenef;
import net.nouha.beneficiaireservice.repository.BeneficiaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BeneficiaireRepository beneficiaireRepository){
        return args -> {
            beneficiaireRepository.save(Beneficiaire.builder().nom("Samih").prenom("Nouha").rib("123456781234567").type(TypeBenef.MORALE).build());
            beneficiaireRepository.save(Beneficiaire.builder().nom("SET").prenom("Nouhaila").rib("600012345678000").type(TypeBenef.PHYSIQUE).build());

            beneficiaireRepository.findAll().forEach(b->{
                System.out.println("================");
                System.out.println("Nom : "+b.getNom());
                System.out.println("Prenom : "+b.getPrenom());
                System.out.println("RIB : "+b.getRib());
                System.out.println("Type : "+b.getType());
                System.out.println("================");
            });
        };
    }
}
