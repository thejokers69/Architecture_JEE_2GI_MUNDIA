package ma.mundiapolis.tp4_security_patients.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.mundiapolis.tp4_security_patients.entities.Patient;
import ma.mundiapolis.tp4_security_patients.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Contrôleur Spring MVC pour gérer les patients.
@Controller
@AllArgsConstructor
public class PatientController {

    // Référentiel pour interagir avec la base de données
    private PatientRepository patientRepository;
    // Liste paginée et filtrée des patients
    @GetMapping(path = "/user/index")
    public String patients(Model model ,
                           @RequestParam(name = "page",defaultValue = "0") int page ,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name = "keyword",defaultValue = "")String keyword){
        // Récupère une page de patients en fonction du mot-clé
        Page<Patient> pagePatients = patientRepository.findByNameContains(keyword , PageRequest.of(page,size));
        // Ajoute les patients et les données de pagination au modèle
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients" ;
    }
    // Supprime un patient par ID
    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")// que si le role est admin , il est permit de supprimer le patient
    public String delete(Long id,String keyword , int page){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    // Page d'accueil
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }
    // Formulaire d'ajout d'un patient
    @GetMapping("/admin/formPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatients(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    // Formulaire de modifier les informations de patient
    @GetMapping("/admin/editPatient")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public String editPatient(Model model, Long id, String keyword, int page){
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatients";
    }
    // Sauvegarde un patient (ajout ou modification)
    @PostMapping("/admin/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
}
