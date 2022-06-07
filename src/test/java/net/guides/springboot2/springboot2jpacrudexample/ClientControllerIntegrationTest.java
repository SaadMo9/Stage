package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import net.guides.springboot2.springboot2jpacrudexample.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Client client = restTemplate.getForObject(getRootUrl() + "/employees/1", Client.class);
		System.out.println(client.getFirstName());
		assertNotNull(client);
	}

	@Test
	public void testCreateEmployee() {
		Client client = new Client();
		client.setEmailId("admin@gmail.com");
		client.setFirstName("admin");
		client.setLastName("admin");

		ResponseEntity<Client> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", client, Client.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		Client client = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Client.class);
		client.setFirstName("admin1");
		client.setLastName("admin2");

		restTemplate.put(getRootUrl() + "/employees/" + id, client);

		Client updatedClient = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Client.class);
		assertNotNull(updatedClient);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		Client client = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Client.class);
		assertNotNull(client);

		restTemplate.delete(getRootUrl() + "/employees/" + id);

		try {
			client = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Client.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
