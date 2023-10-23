package com.example.jobportal.service;

import com.example.jobportal.entities.JobModel;
import com.example.jobportal.entities.UserModel;
import com.example.jobportal.exceptionHandler.JobNotFoundException;
import com.example.jobportal.exceptionHandler.RequestParameterNullException;
import com.example.jobportal.model.request.UserApplicationRequest;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.repository.UserApplicationsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    UserApplicationsRepository userApplicationsRepository;

    public Long applyToJob(UserApplicationRequest request) throws Exception {
        if (request.getJobId() == null || request.getUserEmail().isEmpty() || request.getFirstName().isEmpty() ||
        request.getLastName().isEmpty() || request.getPhoneNumber().isEmpty() ||
        request.getPrimarySkills().isEmpty()){
            throw new RequestParameterNullException("Request Parameters is Null or Empty");
        }
        UserModel userModel = createUserModel(request);
       UserModel user =  userApplicationsRepository.save(userModel);
        log.info("User Application Details :  {} " , user );
        return request.getJobId();
    }

    public void withdrawApplication(String phoneNumber) {
        userApplicationsRepository.deleteByPhoneNumber(phoneNumber);
        log.info("User Application with phone Number {} Deleted. " , phoneNumber );
    }

    private UserModel createUserModel(UserApplicationRequest request) throws JobNotFoundException {
        Set<JobModel> jobIds = new HashSet<>();
        if (userApplicationsRepository.existsByPhoneNumber(request.getPhoneNumber())){
            log.info("User Exists {}" , request.getPhoneNumber());
            jobIds = userApplicationsRepository.findByPhoneNumber(request.getPhoneNumber()).getJobId();
            log.info("Job Ids{}", jobIds);
            jobIds.add(getJobModelById(request.getJobId()));
        }
            return UserModel.builder().firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .userEmail(request.getUserEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .primarySkills(request.getPrimarySkills())
                    .jobId(jobIds)
                    .build();
    }

    private JobModel getJobModelById(Long id) throws JobNotFoundException  {
        Optional<JobModel> jobModel =  jobRepository.findById(id);
        if (jobModel.isEmpty()) {
            throw new JobNotFoundException(id);
        } else{
            return jobModel.get();
        }
    }
}
