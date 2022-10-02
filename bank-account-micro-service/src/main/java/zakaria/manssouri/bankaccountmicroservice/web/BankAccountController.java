package zakaria.manssouri.bankaccountmicroservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;
import zakaria.manssouri.bankaccountmicroservice.repositories.BankAccountRepository;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BankAccountController {

    private BankAccountRepository bankAccountRepository;

    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Account %s not found",id)));
    }
}
