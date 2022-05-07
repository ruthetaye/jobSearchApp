package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface SkillRepository extends JpaRepository<Skill,Long>, JpaSpecificationExecutor<Skill> {

    List<Skill> findSkillsByJob_Id(long jobId);

//    @Query("select Skill from Skill s join Job j on j.id=s.job.id where j.id=?1 and s.id=?2")
    @Query(value = "select * from skill s join job j on j.id = s.job_id where j.id=?1 and s.id=?2", nativeQuery = true)
    Skill findSkillByJob_IdAndSkillId(long jobId, long skillId);

    @Query(value="delete s from skill s join job j on j.id = s.job_id where j.id=?1 and s.id=?2",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteSkillByJobIdAndSkillId(long jobId, long skillId);


}
