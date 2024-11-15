// File: src/main/java/ma/mundiapolis/tp3_gere_patient/services/PatientService.java
package ma.mundiapolis.tp3_gere_patient.services;

import ma.mundiapolis.tp3_gere_patient.entities.Patient;
import ma.mundiapolis.tp3_gere_patient.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        System.out.println("Patient saved : " + patient);
        return patientRepository.save(patient);
    }

    public Page<Patient> getAllPatients(String word, int page, int size) {
        return patientRepository.findByNameContains(word, PageRequest.of(page, size));
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
