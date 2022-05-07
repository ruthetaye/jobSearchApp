package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long> {

    List<Interview> findInterviewsByJob_Id(long jobId);

    Interview findInterviewByJob_IdAndId(long jobId,long interviewId);

    @Transactional
    @Modifying
    void deleteInterviewByJob_IdAndId(long jobId, long interviewId);

    @Query("SELECT i FROM Interview i WHERE i.date > :startDate AND i.date < :endDate")
    List<Interview> findInterviewsByDateWithin(LocalDate startDate, LocalDate endDate);


}
