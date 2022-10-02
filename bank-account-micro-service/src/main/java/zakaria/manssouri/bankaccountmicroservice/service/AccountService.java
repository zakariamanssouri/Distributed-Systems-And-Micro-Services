package zakaria.manssouri.bankaccountmicroservice.service;

import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountRequestDTO;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;
import zakaria.manssouri.bankaccountmicroservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
