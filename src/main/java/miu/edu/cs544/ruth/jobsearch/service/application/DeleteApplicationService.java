package miu.edu.cs544.ruth.jobsearch.service.application;

import miu.edu.cs544.ruth.jobsearch.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;


    public ResponseEntity<String> deleteApplicationById(long id){
        try {
            applicationRepository.deleteApplicationByJob_Id(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }



}
