package miu.edu.cs544.ruth.jobsearch.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class TechnicalInterview extends Interview implements Serializable {

    private String duration;
    @Enumerated(EnumType.STRING)
    private Location location;
    private String questions;

    public TechnicalInterview() {
    }

    public TechnicalInterview(LocalDate date, String phone, String email, String duration, Location location) {
        super(date, phone, email);
        this.duration = duration;
        this.location = location;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TechnicalInterview{" +
                "duration='" + duration + '\'' +
                ", location=" + location +
                ", questions=" + questions +
                '}';
    }
}
