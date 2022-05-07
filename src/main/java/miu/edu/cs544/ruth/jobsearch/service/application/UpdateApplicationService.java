package miu.edu.cs544.ruth.jobsearch.service.application;

import miu.edu.cs544.ruth.jobsearch.entity.Application;
import miu.edu.cs544.ruth.jobsearch.exception.ApplicationException;
import miu.edu.cs544.ruth.jobsearch.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    public Application updateApplication(long id, Application application) {

        Application appFromDB = getApplication(id);

        if(appFromDB !=null){
            appFromDB.setResumeVersion(application.getResumeVersion());
            appFromDB.setDate(application.getDate());
            applicationRepository.save(appFromDB);
        } else{
            handleApplicationError(id);
        }
        return appFromDB;
    }
    private void handleApplicationError(long id){throw new ApplicationException(id);}
    public Application getApplication(long id){
        return applicationRepository.findApplicationByJob_Id(id);
    }
}
