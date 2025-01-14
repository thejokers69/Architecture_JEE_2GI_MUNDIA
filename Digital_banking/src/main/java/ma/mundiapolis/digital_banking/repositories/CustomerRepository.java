package ma.mundiapolis.digital_banking.repositories;

import ma.mundiapolis.digital_banking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
<<<<<<< HEAD
    @Query("select c from Customer c where c.name like :kw ")
    List<Customer> searchCustomer(@Param("kw") String keyword);
}
=======
    @Query("select c from Customer c where c.name like :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);
}
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
