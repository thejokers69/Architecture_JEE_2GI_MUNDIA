package ma.mundiapolis.tp4_security_patients.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/notAuthorzed")
    public String notAuthorized() {
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
