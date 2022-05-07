package miu.edu.cs544.ruth.jobsearch.entity;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class HiringManagerInterview extends Interview implements Serializable {


    private int teamSize;
    @Temporal(TemporalType.DATE)
    private Date startDate;

    public HiringManagerInterview() {
    }

    public HiringManagerInterview(LocalDate date, String phone, String email, int teamSize, Date startDate) {
        super(date, phone, email);
        this.teamSize = teamSize;
        this.startDate = startDate;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Override
    public String toString() {
        return "HiringManagerInterview{" +
                "teamSize=" + teamSize +
                ", startDate=" + startDate +
                '}';
    }
}
