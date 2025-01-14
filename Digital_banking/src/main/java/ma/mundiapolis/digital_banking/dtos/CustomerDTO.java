package ma.mundiapolis.digital_banking.dtos;

<<<<<<< HEAD
import lombok.Data;
=======
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundiapolis.digital_banking.entities.BankAccount;

import jakarta.persistence.*;
import java.util.List;
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
