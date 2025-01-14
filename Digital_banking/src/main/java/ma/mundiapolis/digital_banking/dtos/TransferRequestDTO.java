package ma.mundiapolis.digital_banking.dtos;
import lombok.Data;

<<<<<<< HEAD
import lombok.Data;

=======
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
@Data
public class TransferRequestDTO {
    private String accountSource;
    private String accountDestination;
    private double amount;
    private String description;
}
