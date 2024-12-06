package ma.mundiapolis.digital_banking.repositories;

import ma.mundiapolis.digital_banking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
