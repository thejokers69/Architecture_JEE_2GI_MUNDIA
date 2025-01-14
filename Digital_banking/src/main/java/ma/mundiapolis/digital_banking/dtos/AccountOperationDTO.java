package ma.mundiapolis.digital_banking.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundiapolis.digital_banking.enums.OperationType;
import ma.mundiapolis.digital_banking.entities.BankAccount;

<<<<<<< HEAD
import lombok.Data;
import ma.mundiapolis.digital_banking.enums.OperationType;

=======
import jakarta.persistence.*;
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
