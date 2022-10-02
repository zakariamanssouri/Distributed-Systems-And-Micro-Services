package zakaria.manssouri.bankaccountmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String > {

}
