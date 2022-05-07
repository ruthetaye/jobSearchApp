package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Company;
import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.entity.Skill;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class SkillSpecification {

    public static Specification<Skill> skillsForJobsWithSalaryAndState (double salary, String state){
        return (root,query,criteriaBuilder) -> {
            Join<Job,Skill> jobSkills = root.join("job");
            Join<Company,Job> jobsForCompany = jobSkills.join("company").join("address");

            List<Predicate> conditions = new ArrayList<>();
            conditions.add(criteriaBuilder.equal(jobsForCompany.get("state"),state));
            conditions.add(criteriaBuilder.greaterThan(jobSkills.get("salary"),salary));

            return criteriaBuilder.and(conditions.toArray(new Predicate[]{}));
        };
    }


}
