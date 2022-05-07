package miu.edu.cs544.ruth.jobsearch.controller;

import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import miu.edu.cs544.ruth.jobsearch.service.skill.DeleteSkillService;
import miu.edu.cs544.ruth.jobsearch.service.skill.GetSkillService;
import miu.edu.cs544.ruth.jobsearch.service.skill.PostSkillService;
import miu.edu.cs544.ruth.jobsearch.service.skill.UpdateSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    PostSkillService postSkillService;
    @Autowired
    GetSkillService getSkillService;
    @Autowired
    DeleteSkillService deleteSkillService;
    @Autowired
    UpdateSkillService updateSkillService;

    @PostMapping("/jobs/{id}/skills")
    public Skill addSkill(@RequestBody Skill skill, @PathVariable("id")long id) {
        return postSkillService.addSkill(skill,id);
    }

    @GetMapping("/jobs/{id}/skills")
    public List<Skill> getAllSkills(@PathVariable("id")long id){
        System.out.println("GetAllSkills");
        return getSkillService.getAllSkills(id);
    }

    @GetMapping("/jobs/{id}/skills/{skillId}")
    public Skill getSkillById(@PathVariable("id")long id,@PathVariable("skillId") long skillId){
        System.out.println("GetSkillById");
        return getSkillService.getSkillById(id,skillId);
    }

    @DeleteMapping("/jobs/{id}/skills/{skillId}")
    public ResponseEntity<String> deleteSkill(@PathVariable("id")long id, @PathVariable("skillId")long skillId){
           return deleteSkillService.deleteSkillById(id,skillId);
    }

    @PutMapping("/jobs/{id}/skills/{skillId}")
    public Skill updateSkill(@PathVariable("id")long id, @PathVariable("skillId")long skillId, @RequestBody Skill skill) {

           return updateSkillService.updateSkill(id,skillId,skill);
    }

    @GetMapping(value ="/jobs/skills",params = {"salary","state"})
    public List<Skill> skillsForJobsWithSalaryAndState(@RequestParam("salary")double salary,@RequestParam("state")String state){
        return getSkillService.getSkillsForJobsWithSalaryAndState(salary,state);
    }

}
