package ma.mundiapolis.digital_banking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
<<<<<<< HEAD
import jakarta.persistence.*;
=======
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccounts;
}
