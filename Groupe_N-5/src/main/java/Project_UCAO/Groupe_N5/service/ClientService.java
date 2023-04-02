package Project_UCAO.Groupe_N5.service;

import java.util.List;



import Project_UCAO.Groupe_N5.entity.Client;

public interface ClientService {
    public List<Client >showClients();
    public Client saveClient(Client client );
    public Client getOneClient(Integer id);
    public void deleteClient (Integer id );
   
}
