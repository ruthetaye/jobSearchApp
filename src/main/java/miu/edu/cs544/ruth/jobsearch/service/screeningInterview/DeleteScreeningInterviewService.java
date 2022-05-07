package miu.edu.cs544.ruth.jobsearch.service.screeningInterview;

import miu.edu.cs544.ruth.jobsearch.repository.ScreeningInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteScreeningInterviewService {

    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    public ResponseEntity<String> deleteScreeningInterviewById(long id, long screeningInterviewId){
        try {
            screeningInterviewRepository.deleteScreeningInterviewByJob_IdAndId(id,screeningInterviewId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
