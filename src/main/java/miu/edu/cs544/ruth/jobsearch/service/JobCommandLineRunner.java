package miu.edu.cs544.ruth.jobsearch.service;

import miu.edu.cs544.ruth.jobsearch.entity.*;
import miu.edu.cs544.ruth.jobsearch.repository.ApplicationRepository;
import miu.edu.cs544.ruth.jobsearch.repository.CompanyRepository;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class JobCommandLineRunner implements CommandLineRunner{

    @Autowired
    JobRepository jobRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public void run(String... args) throws Exception {

        Job job1 = new Job( "Senior Associate", 110000.00);
        Job job2 = new Job( "Java Developer", 100000.00);
        Job job3 = new Job( "Software Engineer", 120000.00);
        Job job4 = new Job( "Cloud Associate", 110000.00);
        Job job5 = new Job( "Database Developer", 120000.00);
        Job job6 = new Job( "Front End Developer", 110000.00);
        Job job7 = new Job( "Database Developer 2", 120000.00);
        Job job8 = new Job( "Full Stack Developer", 110000.00);

        Skill skill1 = new Skill("Development",3,"description","javascript");
        Skill skill2 = new Skill("Scripting", 3, "description", "python");
        Skill skill3 = new Skill("Technical Writing", 3, "description", "something");

        List<Skill> skillList = new ArrayList<>();
        skillList.add(skill1);
        skillList.add(skill2);
        skillList.add(skill3);

        job1.setSkills(skillList);

        Application app1 = new Application( new Date(),"2.1");
        app1.setJob(job1);
        Application app2 = new Application( new Date(),"2.3");
        app2.setJob(job4);

        List<Job> microsoftJobList = new ArrayList<>();
        microsoftJobList.add(job1);
        microsoftJobList.add(job2);

        List<Job> amazonJobList = new ArrayList<>();
        amazonJobList.add(job4);
        amazonJobList.add(job5);

        List<Job> kiteStringJobList = new ArrayList<>();
        kiteStringJobList.add(job3);
        kiteStringJobList.add(job6);

        List<Job> robertHalfJobList = new ArrayList<>();
        robertHalfJobList.add(job7);
        robertHalfJobList.add(job8);

        Company company1 = new Company("Microsoft", new Address("Street","City","ST","12345"));
        Company company2 = new Company("Amazon", new Address("Street","City","ST","12345"));

        Recruiter recruiter1 = new Recruiter("KiteString",new Address("street","city","state","code"));
        Recruiter recruiter2 = new Recruiter("RobertHalf",new Address("street","city","ST","code"));

        Client client1 = new Client("Ford",new Address("Street", "city","ST","code"), "www.abc.com");
        Client client2 = new Client("Walgreens",new Address("Street", "city","state","code"),"www.cde.com");

        List<Client> kiteStringClientList = new ArrayList<>();
        kiteStringClientList.add(client1);
        kiteStringClientList.add(client2);

        client1.setJobs(kiteStringJobList);
        client2.setJobs(robertHalfJobList);

        company1.setJobs(microsoftJobList);
        company2.setJobs(amazonJobList);
        recruiter1.setClients(kiteStringClientList);

        LocalDate d1 = LocalDate.of(2022,01,10);
        LocalDate d2 = LocalDate.of(2022,02,7);
        LocalDate d3 = LocalDate.of(2022,02,8);
        LocalDate d4 = LocalDate.of(2022,02,9);
        LocalDate d5 = LocalDate.of(2022,02,10);

        ScreeningInterview screeningInterview1 = new ScreeningInterview(d1, "123-456-7890","what@email.com","John Smith", "fail");
        ScreeningInterview screeningInterview2 = new ScreeningInterview(d2, "123-456-7890","who@email.com","Jill Smith", "pass");
        ScreeningInterview screeningInterview3= new ScreeningInterview( d3, "123-456-7890","where@email.com","Jane Smith", "pass");

        TechnicalInterview technicalInterview1 = new TechnicalInterview(d4, "123-456-7890","what@email.com","1", Location.IN_PERSON);
        TechnicalInterview technicalInterview2 = new TechnicalInterview(d5, "123-777-7890","what@email.com","2", Location.ONLINE);

        HiringManagerInterview hiringManagerInterview1 = new HiringManagerInterview(LocalDate.now(), "123-777-7890","what@email.com",4, new Date());
        HiringManagerInterview hiringManagerInterview2 = new HiringManagerInterview(LocalDate.now(), "123-777-7890","what@email.com",3, new Date());
        HiringManagerInterview hiringManagerInterview3 = new HiringManagerInterview(LocalDate.now(), "123-777-7890","what@email.com",2, new Date());

        List<Interview> job1Interviews = new ArrayList<>();
        job1Interviews.add(screeningInterview1);
        job1Interviews.add(technicalInterview1);
        job1Interviews.add(hiringManagerInterview1);

        List<Interview> job2Interviews = new ArrayList<>();
        job2Interviews.add(screeningInterview2);
        job2Interviews.add(technicalInterview2);
        job2Interviews.add(hiringManagerInterview2);

        job1.setInterviews(job1Interviews);
        job2.setInterviews(job2Interviews);

        applicationRepository.save(app1);
        applicationRepository.save(app2);
        companyRepository.save(company1);
        companyRepository.save(company2);
        companyRepository.save(recruiter1);
        companyRepository.save(recruiter2);

    }

}
