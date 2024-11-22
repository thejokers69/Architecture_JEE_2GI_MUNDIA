package ma.mundiapolis.tp4_security_patients.repositories;

import ma.mundiapolis.tp4_security_patients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface pour gérer les opérations sur l'entité Patient
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Méthode pour rechercher les patients dont le nom contient une chaîne donnée (avec pagination)
    Page<Patient> findByNameContains(String name, Pageable pageable);
}
