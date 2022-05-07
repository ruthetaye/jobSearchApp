package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.entity.Recruiter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class RecruiterSpecification {

    public static Specification<Recruiter> recruitersWithSalary(double salary){
        return (root, query, criteriaBuilder) -> {
            Join<Recruiter, Job> recruiterJob = root.join("jobs");
            return criteriaBuilder.greaterThan(recruiterJob.get("salary"),salary);

        };
    }
}
