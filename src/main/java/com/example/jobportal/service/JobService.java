package com.example.jobportal.service;

import com.example.jobportal.entities.JobModel;
import com.example.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public Long addJob(JobModel jobModel) {
     JobModel returned = jobRepository.save(jobModel);
        System.out.println(returned);
        return returned.getJobId();
    }

    public List<JobModel> getAllJobs() {
        return jobRepository.findAll();
    }

    public void deleteById(Long id) {
        jobRepository.deleteAllById(Collections.singleton(id));
    }
}
