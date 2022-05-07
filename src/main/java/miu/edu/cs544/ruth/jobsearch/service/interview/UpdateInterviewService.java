package miu.edu.cs544.ruth.jobsearch.service.interview;

import miu.edu.cs544.ruth.jobsearch.entity.Interview;
import miu.edu.cs544.ruth.jobsearch.exception.HiringManagerInterviewException;
import miu.edu.cs544.ruth.jobsearch.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateInterviewService {

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    GetInterviewService getInterviewService;

    public Interview updateInterview(long id, long interviewId, Interview interview) {

        Interview interviewFromDB = getInterviewService.getInterviewById(id, interviewId);

        if(interviewFromDB!=null){
            interviewFromDB.setJob(interview.getJob());
            interviewFromDB.setDate(interview.getDate());
            interviewFromDB.setEmail(interview.getEmail());
            interviewFromDB.setPhone(interview.getPhone());
            interviewRepository.save(interviewFromDB);
        } else{
            handleInterviewException(id);
        }

        return interviewFromDB;
    }

        private void handleInterviewException(long id) {
            throw new HiringManagerInterviewException(id);
        }


}
