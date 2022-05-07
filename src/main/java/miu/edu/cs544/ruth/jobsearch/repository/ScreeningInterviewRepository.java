package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.ScreeningInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ScreeningInterviewRepository extends JpaRepository<ScreeningInterview,Long> {

    List<ScreeningInterview> findScreeningInterviewsByJob_Id(long jobId);

    ScreeningInterview findScreeningInterviewByJob_IdAndId(long jobId,long screeningInterviewId);
    @Modifying
    @Transactional
    void deleteScreeningInterviewByJob_IdAndId(long jobId,long screeningInterviewId);
}
