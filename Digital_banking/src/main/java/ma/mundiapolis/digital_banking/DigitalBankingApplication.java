package ma.mundiapolis.digital_banking;

import ma.mundiapolis.digital_banking.entities.AccountOperation;
import ma.mundiapolis.digital_banking.entities.CurrentAccount;
import ma.mundiapolis.digital_banking.entities.Customer;
import ma.mundiapolis.digital_banking.entities.SavingAccount;
import ma.mundiapolis.digital_banking.enums.AccountStatus;
import ma.mundiapolis.digital_banking.enums.OperationType;
import ma.mundiapolis.digital_banking.repositories.AccountOperationRepository;
import ma.mundiapolis.digital_banking.repositories.BankAccountRepository;
import ma.mundiapolis.digital_banking.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Alex","John","Smith").forEach(name->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                // CurrentAccount
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*900000);
                currentAccount.setCreateAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(90000);
                bankAccountRepository.save(currentAccount);
                // Saving Operations
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*900000);
                savingAccount.setCreateAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(account ->{
                        for (int i = 0; i < 10; i++) {
                            AccountOperation accountOperation=new AccountOperation();
                            accountOperation.setOperationDate(new Date());
                            accountOperation.setAmount(Math.random()*12000);
                            accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
                            accountOperation.setBankAccount(account);
                            accountOperationRepository.save(accountOperation);
                        }
                    }
            );
        };
    }
}
