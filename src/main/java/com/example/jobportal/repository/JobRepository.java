package com.example.jobportal.repository;

import com.example.jobportal.entities.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Long> {
}
