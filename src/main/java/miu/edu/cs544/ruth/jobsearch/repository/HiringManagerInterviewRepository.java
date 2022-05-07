package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.HiringManagerInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface HiringManagerInterviewRepository extends JpaRepository<HiringManagerInterview,Long> {

    List<HiringManagerInterview> findHiringManagerInterviewsByJob_Id(long id);

    HiringManagerInterview findHiringManagerInterviewByJob_IdAndId(long id, long hiringManagerInterviewId);
    @Modifying
    @Transactional
    void deleteHiringManagerInterviewByJob_IdAndAndId(long id, long hiringManagerInterviewId);

}
