package miu.edu.cs544.ruth.jobsearch.service.client;

import miu.edu.cs544.ruth.jobsearch.entity.Client;
import miu.edu.cs544.ruth.jobsearch.exception.ClientException;
import miu.edu.cs544.ruth.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    GetClientService getClientService;


    public Client updateClient(long id, Client client){
        Client clientFromDB = getClient(id);

        if(clientFromDB != null){
            clientFromDB.setName(client.getName());
            clientFromDB.setAddress(client.getAddress());
            clientFromDB.setMission(client.getMission());
            clientFromDB.setReason(client.getReason());
            clientFromDB.setWebsite(client.getWebsite());
            clientRepository.save(clientFromDB);
        } else{
            handleClientError(id);
        }
        return clientFromDB;
    }

    private void handleClientError(long id){throw new ClientException(id);}

    public Client getClient(long id){
        return getClientService.getClientById(id);
    }
}
