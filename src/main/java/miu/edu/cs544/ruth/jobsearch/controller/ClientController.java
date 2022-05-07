package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Client;
import miu.edu.cs544.ruth.jobsearch.service.client.DeleteClientService;
import miu.edu.cs544.ruth.jobsearch.service.client.GetClientService;
import miu.edu.cs544.ruth.jobsearch.service.client.PostClientService;
import miu.edu.cs544.ruth.jobsearch.service.client.UpdateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    GetClientService getClientService;
    @Autowired
    PostClientService postClientService;
    @Autowired
    DeleteClientService deleteClientService;
    @Autowired
    UpdateClientService updateClientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id")long id){
        System.out.println("GetClientById");
        return getClientService.getClientById(id);
    }

    @GetMapping()
    public List<Client> getAllClients(){
        System.out.println("Get All Clients");
        return getClientService.getAllClients();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
        return postClientService.addClient(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id){
        return deleteClientService.deleteClientById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client) {
       return updateClientService.updateClient(id,client);
    }


}
