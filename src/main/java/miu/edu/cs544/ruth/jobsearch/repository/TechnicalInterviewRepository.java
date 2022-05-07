package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.TechnicalInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface TechnicalInterviewRepository extends JpaRepository<TechnicalInterview,Long> {

    List<TechnicalInterview> findTechnicalInterviewsByJob_Id(long id);

    TechnicalInterview findTechnicalInterviewByJob_IdAndId(long id,long technicalInterview);
    @Transactional
    @Modifying
    void deleteTechnicalInterviewByJob_IdAndId(long id, long technicalInterviewId);
}
