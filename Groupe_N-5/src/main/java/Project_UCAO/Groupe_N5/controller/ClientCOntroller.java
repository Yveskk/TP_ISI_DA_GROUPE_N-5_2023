package Project_UCAO.Groupe_N5.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.services.ClientService;

public class ClientCOntroller {
    private ClientService ClientService;

	@PostMapping("/addUser")
	public Client addUser(@RequestBody Client Client) {
		return ClientService.createClient(Client);
	}

	@PostMapping("/addUsers")
	public List<Client> addUsers(@RequestBody List<Client> Clients) {
		return ClientService.createClients(Clients);
	}

	@GetMapping("/user/{id}")
	public Client getClientId(@PathVariable int id) {
		return ClientService.getClientId(id);
	}

	@GetMapping("/users")
	public List<Client> getAllClient() {
		return ClientService.getClients();
	}
	/* 
	@PutMapping("/updateuser")
	public Client update(@RequestBody Client Client) {
		return ClientService.updateClient(Client);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}   */
    
}
