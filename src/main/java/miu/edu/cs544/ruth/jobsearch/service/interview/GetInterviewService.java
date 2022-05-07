package miu.edu.cs544.ruth.jobsearch.service.interview;

import miu.edu.cs544.ruth.jobsearch.entity.Interview;
import miu.edu.cs544.ruth.jobsearch.entity.Job;
import miu.edu.cs544.ruth.jobsearch.repository.InterviewRepository;
import miu.edu.cs544.ruth.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GetInterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    JobRepository jobRepository;

    public List<Interview> getAllInterviews(long id){
        return interviewRepository.findInterviewsByJob_Id(id);
    }

    public Interview getInterviewById(long id, long interviewId){
        Job jobFromDB = jobRepository.findById(id).get();
        return interviewRepository.findInterviewByJob_IdAndId(id,interviewId);
    }

    public List<Interview> interviewsWithinAWeek(LocalDate startDate, LocalDate endDate){
        return interviewRepository.findInterviewsByDateWithin(startDate,endDate);
    }
}
