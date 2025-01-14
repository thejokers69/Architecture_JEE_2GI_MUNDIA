package ma.mundiapolis.digital_banking.dtos;

<<<<<<< HEAD
import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.mundiapolis.digital_banking.enums.AccountStatus;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class SavingBankAccountDTO extends BankAccountDTO{
=======
import ma.mundiapolis.digital_banking.enums.AccountStatus;
import lombok.Data;
import java.util.Date;
@Data
public class SavingBankAccountDTO extends BankAccountDTO {
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
<<<<<<< HEAD

=======
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
}
