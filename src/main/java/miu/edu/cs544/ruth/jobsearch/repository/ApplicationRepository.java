package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

    Application findApplicationByJob_Id(long jobId);

    @Modifying
    @Transactional
    void deleteApplicationByJob_Id(long jobId);
}
