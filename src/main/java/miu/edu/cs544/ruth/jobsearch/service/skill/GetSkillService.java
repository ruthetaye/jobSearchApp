package miu.edu.cs544.ruth.jobsearch.service.skill;

import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import miu.edu.cs544.ruth.jobsearch.exception.SkillException;
import miu.edu.cs544.ruth.jobsearch.repository.SkillRepository;
import miu.edu.cs544.ruth.jobsearch.repository.SkillSpecification;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSkillService {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    GetJobService getJobService;
    Skill skill;

    public List<Skill> getAllSkills(long id){
        return skillRepository.findSkillsByJob_Id(id);
    }

    public Skill getSkillById(long id,long skillId) {
        skill = skillRepository.findSkillByJob_IdAndSkillId(id,skillId);
        if(skill!=null){
            return skill;
        } else{
            handleSkillException(id);
        }
        return skill;
    }

    private void handleSkillException(long id) {
        throw new SkillException(id);
    }


    public List<Skill> getSkillsForJobsWithSalaryAndState(double salary, String state){
        return skillRepository.findAll(SkillSpecification.skillsForJobsWithSalaryAndState(salary,state));
    }

}
