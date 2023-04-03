package service;

import Project_UCAO.Groupe_N5.entity.Account;
import controller.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

@Service
public class AccountService {
    AccountRepository er;
    public Account saveAccount(Account accounts){
        return er.save(accounts);

    }
    public void deleteAccount(Integer id){
        er.deleteById(id);
    }
    public Account getOneAccount(Integer id){
        return er.findById(id).get();
    }
}
