package zakaria.manssouri.bankaccountmicroservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public String getBalance();
}
