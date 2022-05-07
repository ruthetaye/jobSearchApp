package miu.edu.cs544.ruth.jobsearch;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import miu.edu.cs544.ruth.jobsearch.jms.Sender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication(excludeName = "Sender")
@EnableJms
@EnableAspectJAutoProxy(proxyTargetClass = true)
@OpenAPIDefinition(info = @Info(title = "Job Search Headless Application"))
public class JobSearchApplication {


    public static void main(String[] args) {
        System.out.println("Start");
        SpringApplication.run(JobSearchApplication.class, args);
        System.out.println("End");
    }

}
