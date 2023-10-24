package com.example.jobportal.repository;

import com.example.jobportal.models.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*****
 * The repository layer containing information about Jobs.
 * **/

@Repository
public interface JobRepository extends JpaRepository<JobModel, Long> {
}
