package ma.mundiapolis.digital_banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
<<<<<<< HEAD
@DiscriminatorValue("CA")
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CurrentAccount extends  BankAccount {
=======
@DiscriminatorValue("CURRENT")
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount {
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
    private double overDraft;
}
