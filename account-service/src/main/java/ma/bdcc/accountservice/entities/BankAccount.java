package ma.bdcc.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.bdcc.accountservice.enums.AccountType;
import ma.bdcc.accountservice.model.Customer;


import java.time.LocalDate;
@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
