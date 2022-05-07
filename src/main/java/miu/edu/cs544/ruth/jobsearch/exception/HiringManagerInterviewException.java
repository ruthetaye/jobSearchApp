package miu.edu.cs544.ruth.jobsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class HiringManagerInterviewException extends RuntimeException{
    public HiringManagerInterviewException(String message){
        super(message);
    }

    public HiringManagerInterviewException(long id){
        super("Error Finding Interview With ID");
    }
}
