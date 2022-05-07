package miu.edu.cs544.ruth.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="Job.jobsInaState", query="SELECT j FROM Job j JOIN j.company c WHERE c.address.state=:state")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private int version;
    private String title;
    private double salary;

    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST)
    private List<Skill> skills= new ArrayList<>();

    @OneToOne(mappedBy ="job")
    @JsonManagedReference
    private Application application;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "job", cascade = CascadeType.PERSIST)
    private List<Interview> interviews = new ArrayList<>();

    public Job() {
    }

    public Job(String title, double salary) {
        this.title = title;
        this.salary = salary;
    }

    public int getVersion() {
        return version;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
        for(Interview interview: interviews){
            interview.setJob(this);
        }
    }

    public Company getCompany(){
        return this.company;
    }

    public void setCompany(Company company){
        this.company=company;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
        for(Skill skill:skills){
            skill.setJob(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                '}';
    }
}
