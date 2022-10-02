package zakaria.manssouri.bankaccountmicroservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import zakaria.manssouri.bankaccountmicroservice.dtos.BankAccountResponseDTO;
import zakaria.manssouri.bankaccountmicroservice.entities.BankAccount;

import java.beans.Beans;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return  bankAccountResponseDTO;
    }
}
