package miu.edu.cs544.ruth.jobsearch.service.skill;

import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import miu.edu.cs544.ruth.jobsearch.exception.SkillException;
import miu.edu.cs544.ruth.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateSkillService {

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    GetSkillService getSkillService;

    public Skill updateSkill(long id, long skillId, Skill skill) {

        Skill skillFromDB = getSkill(id,skillId);
        if(skillFromDB!=null){
            skillFromDB.setName(skill.getName());
            skillFromDB.setDescription(skill.getDescription());
            skillFromDB.setExperience(skill.getExperience());
            skillFromDB.setLanguage(skill.getLanguage());
            skillRepository.save(skillFromDB);
        } else{
            handleSkillException(id);
        }

        return skillFromDB;
    }

    private void handleSkillException(long id){
        throw new SkillException(id);
    }

    public Skill getSkill(long id,long skillId){
        return getSkillService.getSkillById(id,skillId);
    }
}
