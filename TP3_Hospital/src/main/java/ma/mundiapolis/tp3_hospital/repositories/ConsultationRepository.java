package ma.mundiapolis.tp3_hospital.repositories;

import ma.mundiapolis.tp3_hospital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
