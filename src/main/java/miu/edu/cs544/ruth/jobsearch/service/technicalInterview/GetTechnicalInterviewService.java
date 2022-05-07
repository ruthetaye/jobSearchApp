package miu.edu.cs544.ruth.jobsearch.service.technicalInterview;

import miu.edu.cs544.ruth.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.TechnicalInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTechnicalInterviewService {
    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;

    @Autowired
    GetJobService getJobService;

    TechnicalInterview technicalInterview;

    public List<TechnicalInterview> getAllTechnicalInterviews(long id){
        return technicalInterviewRepository.findTechnicalInterviewsByJob_Id(id);
    }

    public TechnicalInterview getTechnicalInterviewById(long id, long technicalInterviewId){
        technicalInterview = technicalInterviewRepository.findTechnicalInterviewByJob_IdAndId(id,technicalInterviewId);
        if(technicalInterview!=null){
            return technicalInterview;
        } else{
            handleTechnicalInterviewException(id);
        }
        return technicalInterview;
    }

    private void handleTechnicalInterviewException(long id){
        throw new HiringManagerInterviewException(id);
    }


}
