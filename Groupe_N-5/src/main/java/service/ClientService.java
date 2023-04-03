package service;

import Project_UCAO.Groupe_N5.entity.Client;
import controller.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
    ClientRepository er;

    public Client saveClient(Client client){
        return er.save(client);

    }
    public List<Client> showClient(){
        return er.findAll();
    }
    public void deleteClient(Integer id){
        er.deleteById(id);

    }
}
