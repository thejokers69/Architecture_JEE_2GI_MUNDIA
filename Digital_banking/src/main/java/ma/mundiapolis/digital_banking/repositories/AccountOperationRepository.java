package ma.mundiapolis.digital_banking.repositories;

import ma.mundiapolis.digital_banking.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
