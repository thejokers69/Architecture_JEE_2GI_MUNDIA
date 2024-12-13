package ma.mundiapolis.digital_banking.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ma.mundiapolis.digital_banking.enums.AccountStatus;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class CurrentBankAccountDTO extends BankAccountDTO{
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double overDraft;
}
