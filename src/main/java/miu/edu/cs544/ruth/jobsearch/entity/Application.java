package miu.edu.cs544.ruth.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class Application implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private int version;
    private Date date;
    private String resumeVersion;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    @JsonBackReference
    private Job job;

    public Application() {
    }

    public Application(Date date, String resumeVersion) {
        this.date = date;
        this.resumeVersion = resumeVersion;
    }

    public int getVersion() {
        return version;
    }

    public Long getId() {
        return id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        this.job.setApplication(this);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getResumeVersion() {
        return resumeVersion;
    }

    public void setResumeVersion(String resumeVersion) {
        this.resumeVersion = resumeVersion;
    }

}
