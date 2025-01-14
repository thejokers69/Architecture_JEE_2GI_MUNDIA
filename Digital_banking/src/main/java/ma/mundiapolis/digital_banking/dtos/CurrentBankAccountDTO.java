package ma.mundiapolis.digital_banking.dtos;

import lombok.Data;
<<<<<<< HEAD
import lombok.EqualsAndHashCode;
=======
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
import ma.mundiapolis.digital_banking.enums.AccountStatus;

import java.util.Date;

@Data
<<<<<<< HEAD
@EqualsAndHashCode(callSuper = true)
public class CurrentBankAccountDTO extends BankAccountDTO{
=======
public class CurrentBankAccountDTO extends BankAccountDTO {
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;
}
