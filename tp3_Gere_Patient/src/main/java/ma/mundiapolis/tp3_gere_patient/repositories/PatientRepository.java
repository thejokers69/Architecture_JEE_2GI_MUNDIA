// File: src/main/java/ma/mundiapolis/tp3_gere_patient/entities/Patient.java
package ma.mundiapolis.tp3_gere_patient.repositories;

import ma.mundiapolis.tp3_gere_patient.entities.Patient;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNameContains(String word, Pageable pageable);
}
