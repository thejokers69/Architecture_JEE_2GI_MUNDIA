// Architecture_JEE_2GI_MUNDIA/Student_app_Mohamed_Lakssir/src/main/java/org/example/student_app_mohamed_lakssir/web/ProductRestService.java
package ma.mundiapolis.tp3_hospital.repositories;

import ma.mundiapolis.tp3_hospital.entities.Patient;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String word, Pageable pageable);

}
