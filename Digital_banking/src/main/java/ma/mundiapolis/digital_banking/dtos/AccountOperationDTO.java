package ma.mundiapolis.digital_banking.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundiapolis.digital_banking.enums.OperationType;
import ma.mundiapolis.digital_banking.entities.BankAccount;

import jakarta.persistence.*;
import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
