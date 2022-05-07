package miu.edu.cs544.ruth.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Company implements Serializable {


    private String mission;
    private String reason;
    private String website;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Recruiter recruiter;

    public Client() {

    }

    public Client(String name, Address address, String website) {
        super(name,address);
        this.mission = "company mission";
        this.reason = "why you wish to work there";
        this.website = website;
    }

//    public void addRecruiter(Recruiter recruiter){
//            recruiters.add(recruiter);
//            recruiter.getClients().add(this);
//    }




    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

//    public List<Recruiter> getRecruiters() {
//        return recruiters;
//    }
//
//    public void setRecruiters(List<Recruiter> recruiters) {
//        this.recruiters = recruiters;
//    }


    @Override
    public String toString() {
        return "Client{" +
                "mission='" + mission + '\'' +
                ", reason='" + reason + '\'' +
                ", website='" + website + '\'' +
                ", recruiter=" + recruiter +
                '}';
    }
}
