package Project_UCAO.Groupe_N5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.service.ClientServiceImpl;


@RestController
public class ClientController {
    
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping("/clients")
    public List<Client> showClients() {
        return clientServiceImpl.showClients();
    }

    @GetMapping("/clients/{id}")
    public Client get(@PathVariable Integer id) {
        return clientServiceImpl.getOneClient(id);
    }

    @PostMapping("/clients")
    public Client save(@RequestBody Client client) {
        //return clientServiceImpl.saveClient(client);
        return new Client();
    }

    @PutMapping("/clients")
    public Client update(@PathVariable Integer id, @RequestBody Client client) {
        client.setId(id);
        return clientServiceImpl.saveClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable Integer id) {
        clientServiceImpl.deleteClient(id);
    }
}
