package miu.edu.cs544.ruth.jobsearch.service.recruiter;

import miu.edu.cs544.ruth.jobsearch.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeleteRecruiterService {

    @Autowired
    RecruiterRepository recruiterRepository;

    public ResponseEntity<String> deleteRecruiterById(@PathVariable long id){
        try {
            recruiterRepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}
