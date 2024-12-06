package ma.mundiapolis.digital_banking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundiapolis.digital_banking.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType = DiscriminatorType.STRING)
@Data @AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;
}
