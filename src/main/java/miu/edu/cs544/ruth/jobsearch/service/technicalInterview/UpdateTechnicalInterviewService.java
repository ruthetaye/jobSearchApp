package miu.edu.cs544.ruth.jobsearch.service.technicalInterview;

import miu.edu.cs544.ruth.jobsearch.entity.TechnicalInterview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTechnicalInterviewService {

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;
    @Autowired
    GetTechnicalInterviewService getTechnicalInterviewService;

    public TechnicalInterview updateTechnicalInterview(long id, long technicalInterviewId, TechnicalInterview technicalInterview) {

        TechnicalInterview technicalInterviewFromDB = getTechnicalInterview(id,technicalInterviewId);
        if(technicalInterviewFromDB!=null){
            technicalInterviewFromDB.setDuration(technicalInterview.getDuration());
            technicalInterviewFromDB.setLocation(technicalInterview.getLocation());
            technicalInterviewRepository.save(technicalInterviewFromDB);
        } else{
            handleTechnicalInterviewException(id);
        }
        return technicalInterviewFromDB ;
    }

    private void handleTechnicalInterviewException( long id){
        throw new HiringManagerInterviewException(id);
    }

    public TechnicalInterview getTechnicalInterview(long id, long technicalInterviewId){
        System.out.println(getTechnicalInterviewService.getTechnicalInterviewById(id, technicalInterviewId));
        return getTechnicalInterviewService.getTechnicalInterviewById(id, technicalInterviewId);
    }


}
