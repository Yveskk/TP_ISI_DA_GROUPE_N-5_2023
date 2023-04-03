package service;

import Project_UCAO.Groupe_N5.entity.Account;
import controller.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository er;
    public Account saveAccount(Account accounts){
        return er.save(accounts);

    }
    public List<Account> showAccount(){
        return er.findAll();
    }
    public void deleteAccount(Integer id){
        er.deleteById(id);
    }
    public Account getOneAccount(Integer id){
        return er.findById(id).get();
    }
}
