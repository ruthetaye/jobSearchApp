package miu.edu.cs544.ruth.jobsearch.repository;

import miu.edu.cs544.ruth.jobsearch.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
