package miu.edu.cs544.ruth.jobsearch.service.skill;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import miu.edu.cs544.ruth.jobsearch.repository.SkillRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSkillService {
    @Autowired
    SkillRepository skillRepository;

    @Autowired
    GetJobService getJobService;

    public Skill addSkill(Skill skill, long id){
        setJobForSkill(getJobForSkill(id),skill);
        return skillRepository.save(skill);
    }

    public Job getJobForSkill(long id){
        return getJobService.getJobById(id);
    }
    public void setJobForSkill(Job job, Skill skill){
        skill.setJob(job);
    }
}
