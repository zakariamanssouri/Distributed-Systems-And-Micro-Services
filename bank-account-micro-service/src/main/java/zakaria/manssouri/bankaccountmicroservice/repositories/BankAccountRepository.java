package zakaria.manssouri.bankaccountmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;
import zakaria.manssouri.bankaccountmicroservice.enums.AccountType;

import javax.websocket.server.PathParam;
import java.util.List;

@RepositoryRestResource // generate get post delete put methods for manipulating BankAccount
public interface BankAccountRepository extends JpaRepository<BankAccount,String > {
    @RestResource(path = "/byType")
    List<BankAccount> findByType(@Param("t") AccountType type);
}
