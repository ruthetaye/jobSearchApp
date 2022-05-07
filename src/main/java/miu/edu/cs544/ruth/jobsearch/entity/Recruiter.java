package miu.edu.cs544.ruth.jobsearch.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("RECRUIT")
public class Recruiter extends Company implements Serializable {


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recruiter")
    private List<Client> clients = new ArrayList<>();

    public Recruiter() {
    }

    public Recruiter(String name, Address address){
        super(name,address);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
        for(Client client:clients){
            client.setRecruiter(this);
        }
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "clients=" + clients +
                '}';
    }
}
