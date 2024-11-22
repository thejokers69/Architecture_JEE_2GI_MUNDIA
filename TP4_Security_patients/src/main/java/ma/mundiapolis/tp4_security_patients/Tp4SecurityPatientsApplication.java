 // /Users/thejoker/IdeaProjects/Architecture_JEE_2GI_MUNDIA/TP4_Security_patients/src/main/java/ma/mundiapolis/tp4_security_patients/Tp4SecurityPatientsApplication.java
package ma.mundiapolis.tp4_security_patients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Tp4SecurityPatientsApplication implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Tp4SecurityPatientsApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{}

}
