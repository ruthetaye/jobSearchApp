package miu.edu.cs544.ruth.jobsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class CompanyException extends RuntimeException{
    public CompanyException(String message){
        super(message);
    }

    public CompanyException(long id){
        super("Error Finding Company With ID");
    }
}
