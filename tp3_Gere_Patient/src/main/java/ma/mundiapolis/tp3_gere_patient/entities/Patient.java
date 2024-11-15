// File: src/main/java/ma/mundiapolis/tp3_gere_patient/entities/Patient.java
package ma.mundiapolis.tp3_gere_patient.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Email(message = "The email address must be well formatted")
    private String email;

    private boolean sick;

    @Min(0)
    private int score;

    @NotNull
    private String gender;


}
