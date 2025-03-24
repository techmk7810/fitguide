package com.example.guide.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.guide.Data.Client;
import com.example.guide.Repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
			} 

	public List<Client> showClients() {
		return this.clientRepository.findAll();
			}

	public Client getClient(Integer id) throws Exception {
		Client ct =  this.clientRepository.findById(id).orElse(null);
		if(ct==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This id doesn't Exist");
			}
		return ct;
			}

	public Client updateClient(Integer id,Client ct) throws Exception {
		Client client =  this.clientRepository.findById(id).orElse(null);
		if(client==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This id doesn't Exist");
			}
		else {
			this.clientRepository.save(client);
		}
		return client;
		}

	public void deleteClient(int id) {
	clientRepository.deleteById(id);
	}

	public String signIn(String u, String p) {
		List<Client> clients = clientRepository.findAll();
		for (Client client : clients) {
			if (u.equals(client.getuName()) && p.equals(client.getuPassword())) {
				return "Signed In. Client ID: " + client.getClientId();
			}
		}
		return "Failed: Invalid username or password.";
	}

}
