package ma.mundiapolis.digital_banking.repositories;

import ma.mundiapolis.digital_banking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
