package miu.edu.cs544.ruth.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Interview implements Serializable {
    @Version
    private int version;
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Job job;

    public Interview() {
    }

    public Interview(LocalDate date, String phone, String email){
        this.date=date;
        this.phone=phone;
        this.email=email;
    }

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public Job getJob(){
        return this.job;
    }

    public void setJob(Job job){
        this.job=job;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", job=" + job +
                '}';
    }
}
