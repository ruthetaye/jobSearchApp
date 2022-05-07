package miu.edu.cs544.ruth.jobsearch.service.skill;

import miu.edu.cs544.ruth.jobsearch.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteSkillService {

    @Autowired
    SkillRepository skillRepository;

    public ResponseEntity<String> deleteSkillById(long id, long skillId){
        try {
            skillRepository.deleteSkillByJobIdAndSkillId(id,skillId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }



}
