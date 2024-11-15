package ma.mundiapolis.tp3_hospital.services;

import ma.mundiapolis.tp3_hospital.entities.Patient;
import ma.mundiapolis.tp3_hospital.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;

public class PatientService {
    private PatientRepository patientRepository;
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientBuId(Long id){
        return patientRepository.findById(id);
    }
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}
