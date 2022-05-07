package miu.edu.cs544.ruth.jobsearch.service.client;

import miu.edu.cs544.ruth.jobsearch.entity.Client;
import miu.edu.cs544.ruth.jobsearch.exception.ClientException;
import miu.edu.cs544.ruth.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientService {

    @Autowired
    ClientRepository clientRepository;

    Client client;

    public Client getClientById(long id) {
        client = clientRepository.findById(id).get();
        if(client!=null){
            return client;
        } else{
            handleClientError(id);
        }
        return client;
    }

    public List<Client> getAllClients() {return clientRepository.findAll();
    }

    private void handleClientError(long id){throw new ClientException(id);}


}
