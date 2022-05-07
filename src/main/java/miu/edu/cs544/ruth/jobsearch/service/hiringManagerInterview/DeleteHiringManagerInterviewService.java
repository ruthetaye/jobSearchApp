package miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview;

import miu.edu.cs544.ruth.jobsearch.repository.HiringManagerInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteHiringManagerInterviewService {

    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;

    public ResponseEntity<String> deleteHiringManagerInterviewById(long id, long hiringManagerInterviewId){
        try {
            hiringManagerInterviewRepository.deleteHiringManagerInterviewByJob_IdAndAndId(id,hiringManagerInterviewId);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
