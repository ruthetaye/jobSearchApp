package miu.edu.cs544.ruth.jobsearch.service.screeningInterview;
import miu.edu.cs544.ruth.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.ScreeningInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetScreeningInterviewService {
    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    @Autowired
    GetJobService getJobService;

    ScreeningInterview screeningInterview;



    public List<ScreeningInterview> getAllScreeningInterviews(long id){
        return screeningInterviewRepository.findScreeningInterviewsByJob_Id(id);
    }

    public ScreeningInterview getScreeningInterviewById(long id, long screeningInterviewId){
       screeningInterview = screeningInterviewRepository.findScreeningInterviewByJob_IdAndId(id,screeningInterviewId);
        if(screeningInterview!=null){
            return screeningInterview;
        } else{
            handleScreeningException(id);
        }
        return screeningInterview;
    }

    private void handleScreeningException(long id) {
        throw new HiringManagerInterviewException(id);
    }


}
