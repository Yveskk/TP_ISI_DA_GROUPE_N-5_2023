package controller;

import Project_UCAO.Groupe_N5.entity.Client;
import org.springframework.web.bind.annotation.*;
import service.ClientService;
import java.util.List;


public class ClientController {
    ClientService es;
    public Client saveClient(Client client){
        client.setPhoneNumber(
                client.getLastName().substring(0, 1).toUpperCase()
                        +client.getFirstName().substring(0, 1).toUpperCase()
                        +client.getBirthDate().getYear());
    }
    public List<Client> showClient(){
        return es.showClient();
    }
    @DeleteMapping("client/{id}")
    public void deleteClient(@PathVariable Integer id){
        es.deleteClient(id);
    }
    @PutMapping("client/{id}")
    public Client UpdateClient(@PathVariable Integer id, @RequestMapping Client){
        client.setId(id);
        return es.saveClient(client);
    }




}
