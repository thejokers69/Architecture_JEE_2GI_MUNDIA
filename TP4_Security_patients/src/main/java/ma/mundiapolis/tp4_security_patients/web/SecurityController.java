package ma.mundiapolis.tp4_security_patients.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// Contrôleur Spring MVC pour gérer la sécurité.
@Controller
public class SecurityController {
    // Gère les accès refusés (erreur 403).
    @GetMapping("/notAuthorzed")
    public String notAuthorized() {
        return "notAuthorized";
    }
    // Gère la page de connexion.
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
