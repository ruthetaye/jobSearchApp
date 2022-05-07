package miu.edu.cs544.ruth.jobsearch.service.technicalInterview;

import miu.edu.cs544.ruth.jobsearch.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteTechnicalInterviewService {

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;

    public ResponseEntity<String> deleteTechnicalInterviewById(long id, long technicalInterviewId){
        try {
            technicalInterviewRepository.deleteTechnicalInterviewByJob_IdAndId(id,technicalInterviewId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }
}
