package ma.mundiapolis.digital_banking;

import ma.mundiapolis.digital_banking.dtos.BankAccountDTO;
import ma.mundiapolis.digital_banking.dtos.CurrentBankAccountDTO;
import ma.mundiapolis.digital_banking.dtos.CustomerDTO;
import ma.mundiapolis.digital_banking.dtos.SavingBankAccountDTO;
import ma.mundiapolis.digital_banking.entities.AccountOperation;
import ma.mundiapolis.digital_banking.entities.CurrentAccount;
import ma.mundiapolis.digital_banking.entities.Customer;
import ma.mundiapolis.digital_banking.entities.SavingAccount;
import ma.mundiapolis.digital_banking.enums.AccountStatus;
import ma.mundiapolis.digital_banking.enums.OperationType;
import ma.mundiapolis.digital_banking.exceptions.CustomerNotFoundException;
import ma.mundiapolis.digital_banking.repositories.AccountOperationRepository;
import ma.mundiapolis.digital_banking.repositories.BankAccountRepository;
import ma.mundiapolis.digital_banking.repositories.CustomerRepository;
import ma.mundiapolis.digital_banking.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
@EntityScan(basePackages = "ma.mundiapolis.digital_banking.entities")
public class DigitalBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService){
        return args -> {
<<<<<<< HEAD
            Stream.of("Ayman","Ahmed","Salah").forEach(name->{
=======
            Stream.of("Hassan","Imane","Mohamed").forEach(name->{
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
                CustomerDTO customer=new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                bankAccountService.saveCustomer(customer);
            });
            bankAccountService.listCustomers().forEach(customer->{
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
            for (BankAccountDTO bankAccount:bankAccounts){
                for (int i = 0; i <10 ; i++) {
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDTO){
                        accountId=((SavingBankAccountDTO) bankAccount).getId();
                    } else{
                        accountId=((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
                    bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
    }
    //@Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
        return args -> {
<<<<<<< HEAD
            Stream.of("Hamza","Ayoub","Youssef").forEach(name->{
=======
            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
                Customer customer=new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust->{
                CurrentAccount currentAccount=new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount=new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);

            });
            bankAccountRepository.findAll().forEach(acc->{
                for (int i = 0; i <10 ; i++) {
                    AccountOperation accountOperation=new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }

            });
        };

    }

}