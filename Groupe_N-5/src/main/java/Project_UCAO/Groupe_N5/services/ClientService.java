package Project_UCAO.Groupe_N5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.repository.clientRepository;

public class ClientService {
    @Autowired
	private clientRepository clientRepository;

	public Client createClient(Client Client) {
		return clientRepository.save(Client);
	}

	public List<Client> createClients(List<Client> Clients) {
		return clientRepository.saveAll(Clients);
	}

	public Client getClientId(int id) {
		return clientRepository.findById(id).orElse(null);
	}

	public List<Client> getClients() {
		return clientRepository.findAll();
	}
	
	/*public Client updateUser(Client Client) {
		Client oldUser=null;
		Optional<Client> optionaluser=clientRepository.findById(Client.getId());
		if(optionaluser.isPresent()) {
			oldUser=optionaluser.get();
			oldUser.setName(Client.getName());
			oldUser.setAddress(Client.getAddress());
			userRepository.save(oldUser);
		}else {
			return new User();
		}
		return oldUser;
	}
	*/
	public String deleteUserById(int id) {
		clientRepository.deleteById(id);
		return "User got deleted";
	}
}
