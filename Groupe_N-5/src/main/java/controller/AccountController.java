package controller;

import Project_UCAO.Groupe_N5.entity.Account;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;
import service.AccountService;

import java.util.List;

public class AccountController {
    @Autowired
    AccountService es;
    @PostMapping("accounts")
    public Account saveAccount(Account accounts){
        accounts.setType(
                accounts.getDateCreation().substring(0, 1).toUpperCase()
                        +accounts.getNumeroCompte().substring(0, 1).toUpperCase()
                        +accounts.getDateCreation());
    }
    @GetMapping("accounts")
    public List<Account> showAccount(){
        return es.showAccount();
    }
    @PutMapping("accounts/{id}")
    public Account UpdateAccount(@PathVariable Integer id, @Request Account){
        accounts.seId(id);
        return es.saveAccount(accounts);
    }
}
