package miu.edu.cs544.ruth.jobsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Version
    private int version;
    private String name;
    private int experience;
    private String description;
    private String language;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    public Job job;

    public Skill() {
    }

    public Skill(String name, int experience, String description, String language) {
        this.name = name;
        this.experience = experience;
        this.description = description;
        this.language = language;
    }

    public int getVersion() {
        return version;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", job=" + job +
                '}';
    }
}
