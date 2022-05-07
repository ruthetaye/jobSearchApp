package miu.edu.cs544.ruth.jobsearch.service.client;

import miu.edu.cs544.ruth.jobsearch.entity.Client;
import miu.edu.cs544.ruth.jobsearch.exception.ClientException;
import miu.edu.cs544.ruth.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostClientService {

    @Autowired
    ClientRepository clientRepository;
    Client clientToSave;

    public Client addClient(Client client) {

        if(client!=null){
            clientToSave = clientRepository.save(client);
        } else{
            handleClientError("Error creating Client");
        }

        return clientToSave;
    }

    private void handleClientError(String message){throw new ClientException(message);}
}
