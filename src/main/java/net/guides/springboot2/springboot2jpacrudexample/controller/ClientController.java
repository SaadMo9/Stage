package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Client;
import net.guides.springboot2.springboot2jpacrudexample.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client introuvable pour cet id :: " + clientId));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping("/clients")
	public Client createClient(@Valid @RequestBody Client client) {
		return clientRepository.save(client);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId,
											   @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client introuvable pour cet id :: " + clientId));

		client.setEmailId(clientDetails.getEmailId());
		client.setLastName(clientDetails.getLastName());
		client.setFirstName(clientDetails.getFirstName());
		client.setAdresse(clientDetails.getAdresse());
		client.setTelephone(clientDetails.getTelephone());
		final Client updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}

	@DeleteMapping("/clients/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client introuvable pour cet id:: " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
