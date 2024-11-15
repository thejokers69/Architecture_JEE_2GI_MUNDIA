// File: src/main/java/ma/mundiapolis/tp3_gere_patient/Tp3GerePatientApplication.java
package ma.mundiapolis.tp3_gere_patient;

import ma.mundiapolis.tp3_gere_patient.entities.Patient;
import ma.mundiapolis.tp3_gere_patient.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp3GerePatientApplication {


    public static void main(String[] args) {
        SpringApplication.run(Tp3GerePatientApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Mohamed", new Date(), "mohamed@example.com", true, 50,"Male" ));
            patientRepository.save(new Patient(null, "Yassine", new Date(), "yassine@example.com", true, 50,"Male" ));
            patientRepository.save(new Patient(null, "Omar", new Date(), "omar@example.com", true, 50,"Male" ));
        };
    }

}

