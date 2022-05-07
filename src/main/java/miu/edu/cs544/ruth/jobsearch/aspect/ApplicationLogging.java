package miu.edu.cs544.ruth.jobsearch.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLogging {

    @Before("execution(* miu.edu.cs544.ruth.jobsearch.service.application.DeleteApplicationService.*(..))")
    public void beforeDelete(JoinPoint joinPoint){
        System.out.println("Starting Delete: "+joinPoint.getSignature().getDeclaringTypeName()+" : "+joinPoint.getSignature().getName());
    }
}
