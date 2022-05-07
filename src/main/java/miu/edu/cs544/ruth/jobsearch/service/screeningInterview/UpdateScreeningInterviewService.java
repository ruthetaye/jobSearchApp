package miu.edu.cs544.ruth.jobsearch.service.screeningInterview;

import miu.edu.cs544.ruth.jobsearch.entity.ScreeningInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.ScreeningInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateScreeningInterviewService {
    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;
    @Autowired
    GetScreeningInterviewService getScreeningInterviewService;

    public ScreeningInterview updateScreeningInterview(long id, long screeningInterviewId, ScreeningInterview screeningInterview) {

        ScreeningInterview screeningInterviewFromDB = getScreeningInterview(id,screeningInterviewId);

        if(screeningInterviewFromDB!=null){
            screeningInterviewFromDB.setName(screeningInterview.getName());
            screeningInterviewFromDB.setResult(screeningInterview.getResult());
            screeningInterviewRepository.save(screeningInterviewFromDB);
        } else{
            handleScreeningException(id);
        }

        return screeningInterviewFromDB ;
    }

    private void handleScreeningException(long id){
        throw new HiringManagerInterviewException(id);
    }

    public ScreeningInterview getScreeningInterview(long id, long screeningInterviewId){
        System.out.println(getScreeningInterviewService.getScreeningInterviewById(id, screeningInterviewId));
        return getScreeningInterviewService.getScreeningInterviewById(id, screeningInterviewId);
    }


}
