package controller;

import Project_UCAO.Groupe_N5.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.PutMapping;
import service.AccountService;

public class AccountController {
    AccountService es;

    public Account saveAccount(Account accounts){
        accounts.setType(
                accounts.getDateCreation().substring(0, 1).toUpperCase()
                        +accounts.getNumeroCompte().substring(0, 1).toUpperCase()
                        +accounts.getDateCreation().getYear());
    }
}
