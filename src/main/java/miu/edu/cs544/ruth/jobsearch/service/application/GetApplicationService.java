package miu.edu.cs544.ruth.jobsearch.service.application;

import miu.edu.cs544.ruth.jobsearch.entity.Application;
import miu.edu.cs544.ruth.jobsearch.exception.ApplicationException;
import miu.edu.cs544.ruth.jobsearch.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    Application application;
    public Application getApplicationById(long id) {
        application = applicationRepository.findApplicationByJob_Id(id);
        if(application!=null){
            return application;
        } else {
            handleApplicationError(id);
        }
        return application;
    }

    private void handleApplicationError(long id){throw new ApplicationException(id);}
}
