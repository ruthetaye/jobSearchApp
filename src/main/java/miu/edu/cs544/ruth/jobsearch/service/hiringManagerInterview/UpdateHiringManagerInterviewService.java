package miu.edu.cs544.ruth.jobsearch.service.hiringManagerInterview;

import miu.edu.cs544.ruth.jobsearch.entity.HiringManagerInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.HiringManagerInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateHiringManagerInterviewService {
    @Autowired
    HiringManagerInterviewRepository hiringManagerInterviewRepository;
    @Autowired
    GetHiringManagerInterviewService getHiringManagerInterviewService;

    public HiringManagerInterview updateHiringManagerInterview(long id, long hiringManagerInterviewId, HiringManagerInterview hiringManagerInterview) {
         HiringManagerInterview hiringManagerInterviewFromDB = getHiringManagerInterview(id,hiringManagerInterviewId);

         if(hiringManagerInterviewFromDB!=null){
             hiringManagerInterviewFromDB.setStartDate(hiringManagerInterview.getStartDate());
             hiringManagerInterviewFromDB.setTeamSize(hiringManagerInterview.getTeamSize());
             hiringManagerInterviewRepository.save(hiringManagerInterviewFromDB);
         } else{
             handleHiringException(id);
         }

        return hiringManagerInterviewFromDB ;
    }

    private void handleHiringException(long id) {
        throw new HiringManagerInterviewException(id);
    }

    public HiringManagerInterview getHiringManagerInterview(long id, long hiringManagerInterviewId){
        System.out.println(getHiringManagerInterviewService.getHiringManagerInterviewById(id, hiringManagerInterviewId));
        return getHiringManagerInterviewService.getHiringManagerInterviewById(id, hiringManagerInterviewId);
    }
}
