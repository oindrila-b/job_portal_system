package com.example.jobportal.service;

import com.example.jobportal.models.JobModel;
import com.example.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
/****
 *  The service layer for all job related processing. This class is responsible
 *  for adding a new job and getting a list of all the jobs in the repository.
 *
 * **/

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    /*****
     *  This method is responsible for adding a new Job in the database.
     * @param jobModel The object that gets persisted in the database
     * @return jobId
     * **/
    public Long addJob(JobModel jobModel) {
     JobModel returned = jobRepository.save(jobModel);
        System.out.println(returned);
        return returned.getJobId();
    }

    /*****
     * This method gets all the jobs present in a database.
     * @return List<JobModel>
     * **/
    public List<JobModel> getAllJobs() {
        return jobRepository.findAll();
    }

    /*****
     * This method deletes a job by ID.
     * **/
    public void deleteById(Long id) {
        jobRepository.deleteAllById(Collections.singleton(id));
    }
}
