package miu.edu.cs544.ruth.jobsearch.entity;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class ScreeningInterview extends Interview implements Serializable {


    private String name;
    private String result;

    public ScreeningInterview() {
    }

    public ScreeningInterview(LocalDate date, String phone, String email, String name, String result) {
        super(date, phone, email);
        this.name = name;
        this.result = result;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ScreeningInterview{" +
                "id='"+getId()+'\''+
                "name='" + name + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
