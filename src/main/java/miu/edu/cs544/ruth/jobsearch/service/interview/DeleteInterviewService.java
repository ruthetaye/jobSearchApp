package miu.edu.cs544.ruth.jobsearch.service.interview;

import miu.edu.cs544.ruth.jobsearch.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteInterviewService {
    @Autowired
    InterviewRepository interviewRepository;

    public ResponseEntity<String> deleteInterviewById(long id, long interviewId){
        try {
            interviewRepository.deleteInterviewByJob_IdAndId(id,interviewId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
