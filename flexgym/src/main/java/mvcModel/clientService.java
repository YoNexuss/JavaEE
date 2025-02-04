
package mvcModel;

import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import entities.Client;
import jakarta.persistence.*;

/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class clientService {
	@PersistenceContext(unitName="flexgym")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public clientService() {
        // TODO Auto-generated constructor stub
    }
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<Client>();
        TypedQuery<Client> query = em.createNamedQuery("Client.findAll", Client.class);
        clients = query.getResultList();
        return clients;
    }
    public List<Client> deleteClientById(int clientId) {
        List<Client> clients = new ArrayList<Client>();
        Client client = em.find(Client.class, clientId);
        if(client != null) {
            em.remove(client);
        }
        TypedQuery<Client> query = em.createNamedQuery("Client.findAll", Client.class);
        clients = query.getResultList();
        return clients;
    }
    public Client getClientById(int clientId) {
        return em.find(Client.class, clientId);
    }
    public Client modifyClient(Client client) {
        Client existingClient = em.find(Client.class, client.getClientId());
        if(existingClient != null) {
            existingClient.setClientNom(client.getClientNom());
            existingClient.setClientPrenom(client.getClientPrenom());
            existingClient.setClientEmail(client.getClientEmail());
            existingClient.setClientPass(client.getClientPass());
            existingClient.setClientTel(client.getClientTel());
            existingClient.setClientDatenais(client.getClientDatenais());
            em.persist(existingClient);
        }
        return existingClient;
    }
    public Client addClient(Client client) {
        em.persist(client);
        return client;
    }
    
    
    

}

