package zakaria.manssouri.bankaccountmicroservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;
import zakaria.manssouri.bankaccountmicroservice.mappers.AccountMapper;
import zakaria.manssouri.bankaccountmicroservice.repositories.BankAccountRepository;
import zakaria.manssouri.bankaccountmicroservice.service.AccountService;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountController {

    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper mapper;

    public BankAccountController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper mapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.mapper = mapper;
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

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount){
       return  accountService.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
