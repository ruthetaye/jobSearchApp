package miu.edu.cs544.ruth.jobsearch.service.client;

import miu.edu.cs544.ruth.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteClientService {

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<String> deleteClientById(long id){
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }

    }
}
