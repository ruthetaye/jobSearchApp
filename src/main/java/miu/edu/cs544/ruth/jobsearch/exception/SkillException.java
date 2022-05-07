package miu.edu.cs544.ruth.jobsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class SkillException extends RuntimeException{
    public SkillException(String message){
        super(message);
    }

    public SkillException(long id){
        super("Error Finding Skill With ID");
    }
}
