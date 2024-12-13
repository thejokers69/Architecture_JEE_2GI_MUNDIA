package ma.mundiapolis.digital_banking.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("CA")
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CurrentAccount extends  BankAccount {
    private double overDraft;
}
