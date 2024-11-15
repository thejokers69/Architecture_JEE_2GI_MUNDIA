// File: src/main/java/ma/mundiapolis/tp3_gere_patient/entities/Patient.java
package ma.mundiapolis.tp3_gere_patient.web;

import jakarta.validation.Valid;
import ma.mundiapolis.tp3_gere_patient.entities.Patient;
import ma.mundiapolis.tp3_gere_patient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "5") int size,
                                 @RequestParam(value = "word", defaultValue = "") String word) {
        Page<Patient> pagePatients = patientService.getAllPatients(word, page, size);
        model.addAttribute("allPatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("word", word);
        return "patients";
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.getPatientById(id)
                .map(existingPatient -> {
                    existingPatient.setName(patientDetails.getName());
                    existingPatient.setEmail(patientDetails.getEmail());
                    existingPatient.setBirthDate(patientDetails.getBirthDate());
                    existingPatient.setSick(patientDetails.isSick());
                    existingPatient.setScore(patientDetails.getScore());
                    return patientService.savePatient(existingPatient);
                })
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam Long id,
                                @RequestParam String word,
                                @RequestParam int page) {
        patientService.deletePatient(id);
        return "redirect:/patients?page=" + page + "&word=" + word;
    }

    @GetMapping("/add")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@Valid @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Erreur dans le formulaire : " + result.getAllErrors());
            return "add_patient";
        }
        try {
            patientService.savePatient(patient);
            System.out.println("Patient ajouté avec succès. Redirection...");
            return "redirect:/patients";
        } catch (Exception e) {
            // Log en cas d'erreur lors de la sauvegarde
            System.out.println("Erreur lors de l'ajout du patient : " + e.getMessage());
            return "add_patient";
        }
    }
    @GetMapping("/edit/{id}")
    public String showEditPatientForm(@PathVariable Long id, Model model) {
        Optional<Patient> patient = patientService.getPatientById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "edit_patient"; // Create this HTML file for the edit form
        } else {
            return "redirect:/patients"; // Redirect if patient not found
        }
    }

    @PostMapping("/edit")
    public String editPatient(@Valid @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "edit_patient";
        }
        patientService.savePatient(patient); // Update the patient
        return "redirect:/patients";
    }
}
