package ma.mundiapolis.digital_banking.dtos;
<<<<<<< HEAD

import lombok.Data;

=======
import lombok.Data;
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
import java.util.List;
@Data
public class AccountHistoryDTO {
    private String accountId;
    private double balance;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<AccountOperationDTO> accountOperationDTOS;
<<<<<<< HEAD

=======
>>>>>>> b41595aa1dacb7988d954e12ebed9ce7879b2b61
}
