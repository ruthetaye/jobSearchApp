package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long>, JpaSpecificationExecutor<Recruiter> {

    //@Query(value = "select r.* from recruiter r inner join client c on r.id = c.recruiter_id inner join company c2 on c.id = c2.id inner join job j on c2.id = j.company_id where salary>105000", nativeQuery = true)
    //List<Recruiter> recruitersWithJobsHavingSalary();

    @Query(value = "select distinct r.* from recruiter r", nativeQuery = true)
    List<Recruiter> recruitersWithJobsHavingSalary();
}
