package ma.mundiapolis.tp3_hospital.Web;

import lombok.AllArgsConstructor;
import ma.mundiapolis.tp3_hospital.entities.Patient;
import ma.mundiapolis.tp3_hospital.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private final PatientRepository patientRepository;
    @GetMapping(path = "/index")
    public String patients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("listPatients", patients);
        return "patients";
    }
}
