package Project_UCAO.Groupe_N5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.repository.ClientRepository;

@Service
public class ClientServiceImpl  implements ClientService{
    
   @Autowired
   private ClientRepository clientRepository;

@Override
public List<Client> showClients() {
    return clientRepository.findAll();
}

@Override
public Client saveClient(Client client) {
   return clientRepository.save(client);
}

@Override
public Client getOneClient(Integer id) {
    return clientRepository.findById(id).get();

}

@Override
public void deleteClient(Integer id) {
    clientRepository.deleteById(id); 
}
}

