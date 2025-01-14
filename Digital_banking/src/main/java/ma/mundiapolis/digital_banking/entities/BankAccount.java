package ma.mundiapolis.digital_banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundiapolis.digital_banking.enums.AccountStatus;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
<<<<<<< HEAD
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @AllArgsConstructor @NoArgsConstructor
=======
@DiscriminatorColumn(name = "TYPE",length = 10)
@Data @NoArgsConstructor @AllArgsConstructor
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
<<<<<<< HEAD
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
=======

    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
    private List<AccountOperation> accountOperations;
}