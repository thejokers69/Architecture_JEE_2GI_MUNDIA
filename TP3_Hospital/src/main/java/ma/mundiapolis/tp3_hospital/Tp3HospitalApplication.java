package ma.mundiapolis.tp3_hospital;

import ma.mundiapolis.tp3_hospital.entities.Patient;
import ma.mundiapolis.tp3_hospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp3HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 10));
            patientRepository.save(new Patient(null, "Nasser", new Date(), false, 20));
            patientRepository.save(new Patient(null, "Abdo", new Date(), true, 30));
            patientRepository.save(new Patient(null, "Othman", new Date(), false, 40));

            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getName());
            });

        };
    }

}
