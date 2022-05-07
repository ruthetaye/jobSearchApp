package miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview;

import miu.edu.cs544.ruth.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.HiringManagerInterviewRepository;
import miu.edu.cs544.ruth.jobsearch.service.job.GetJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHiringManagerInterviewService {

    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;
    @Autowired
    GetJobService getJobService;

    HiringManagerInterview hiringManagerInterview;

    public List<HiringManagerInterview> getAllHiringManagerInterviews(long id){
        return hiringManagerInterviewRepository.findHiringManagerInterviewsByJob_Id(id);
    }

    public HiringManagerInterview getHiringManagerInterviewById(long id, long hiringManagerInterviewId){
        hiringManagerInterview = hiringManagerInterviewRepository.findHiringManagerInterviewByJob_IdAndId(id,hiringManagerInterviewId);
        if(hiringManagerInterview!=null){
            return hiringManagerInterview;
        } else {
            handleHiringManagerInterviewError(id);
        }
        return hiringManagerInterview;
    }

    private void handleHiringManagerInterviewError(long id) {
        throw new HiringManagerInterviewException(id);
    }


}
