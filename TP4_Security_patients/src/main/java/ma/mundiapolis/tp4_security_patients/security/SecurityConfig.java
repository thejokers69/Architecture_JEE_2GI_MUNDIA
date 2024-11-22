//Users/thejoker/IdeaProjects/Architecture_JEE_2GI_MUNDIA/TP4_Security_patients/src/main/java/ma/mundiapolis/tp4_security_patients/security/SecurityConfig.java
package ma.mundiapolis.tp4_security_patients.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
// Classe de configuration pour la sécurité de l'application
public class SecurityConfig {
    // Bean pour chiffrer les mots de passe avec BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                // Gérer des utilisateurs en mémoire avec rôles et mots de passe chiffrés
                User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER","ADMIN").build()
        );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Configuration des règles de sécurité
        httpSecurity.formLogin().loginPage("/login").permitAll();// Page de connexion personnalisée
        httpSecurity.rememberMe();// active "remember me"
        httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();// Ressources statiques accessibles à tous
        httpSecurity.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");// Pages accessibles aux utilisateurs avec rôle USER
        httpSecurity.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");// Pages accessibles aux administrateurs
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated(); // Toutes les autres pages nécessitent une connexion
        httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");// Redirection en cas d'accès refusé
        return httpSecurity.build();// Construire la configuration de sécurité
    }
}
