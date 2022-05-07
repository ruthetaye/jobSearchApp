package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    @Query(value = "SELECT * from job inner join application a on job.id = a.JOB_ID", nativeQuery = true)
    List<Job> findJobsWithApplication();

    List<Job> jobsInaState(String state);

    @Query(value= "select j.* from job j inner join interview i on j.id = i.job_id group by j.id having count(i.job_id >=2)", nativeQuery = true)
    List<Job> findJobsHavingAtleastTwoInterviews();







}
