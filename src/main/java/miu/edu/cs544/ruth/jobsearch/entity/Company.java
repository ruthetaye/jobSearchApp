package miu.edu.cs544.ruth.jobsearch.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CTYPE")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private int version;
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobs= new ArrayList<>();

    public Company() {
    }

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
        for(Job job: jobs){
            job.setCompany(this);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", jobs=" + jobs +
                '}';
    }
}
