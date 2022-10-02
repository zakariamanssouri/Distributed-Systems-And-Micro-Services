package zakaria.manssouri.bankaccountmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;
import zakaria.manssouri.bankaccountmicroservice.mappers.AccountMapper;
import zakaria.manssouri.bankaccountmicroservice.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .createdAt(new Date())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount savedAccount = bankAccountRepository.save(bankAccount);
       return accountMapper.fromBankAccount(savedAccount);
    }
}
