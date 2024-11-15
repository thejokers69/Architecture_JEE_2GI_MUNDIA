package ma.mundiapolis.tp3_hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor

public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Data dataConsultation;
    private String rapportConsultation;
    private double prixConsultation;
    @OneToOne(mappedBy = "consultaiton")
    private RendezVous rendezVous;
}
