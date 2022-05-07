package miu.edu.cs544.ruth.jobsearch.service.job;

import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DeleteJobService {

    @Autowired
    JobRepository jobRepository;


    public ResponseEntity<String> deleteJobById(@PathVariable long id){
        try {
            jobRepository.deleteById(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}
