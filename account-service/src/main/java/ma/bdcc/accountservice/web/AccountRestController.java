package ma.bdcc.accountservice.web;

import lombok.RequiredArgsConstructor;
import ma.bdcc.accountservice.clients.CustomerRestClient;
import ma.bdcc.accountservice.entities.BankAccount;
import ma.bdcc.accountservice.model.Customer;
import ma.bdcc.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequiredArgsConstructor
public class AccountRestController {
    private final BankAccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;


    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer= customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
