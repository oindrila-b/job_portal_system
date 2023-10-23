package com.example.jobportal.service;

import com.example.jobportal.exceptions.JobNotFoundException;
import com.example.jobportal.models.JobModel;
import com.example.jobportal.models.UserModel;
import com.example.jobportal.models.request.UserApplicationRequestModel;
import com.example.jobportal.models.response.UserList;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.repository.UserApplicationsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    UserApplicationsRepository userApplicationsRepository;

    public Long applyToJob(UserApplicationRequestModel requestModel) throws JobNotFoundException {
            UserModel model = createUserModel(requestModel);
       UserModel user=  userApplicationsRepository.save(model);
        log.info("User Application Details :  {} " , 1 );
        return 1L;
    }

    public void withdrawApplication(String phoneNumber) {
        userApplicationsRepository.deleteById(phoneNumber);
        log.info("User Application with phone NUmber {} Deleted. " , phoneNumber );
    }

    private UserModel createUserModel(UserApplicationRequestModel requestModel) throws JobNotFoundException {
        Set<Long> jobIds = new HashSet<>();
        if (jobRepository.findById(requestModel.getJobId()).isEmpty()) {
            throw new JobNotFoundException(requestModel.getJobId());
        }
        if (userApplicationsRepository.existsById(requestModel.getPhoneNumber())) {
            log.info("User with phone number {} exists", requestModel.getPhoneNumber());
            if (userApplicationsRepository.findById(requestModel.getPhoneNumber()).isPresent()) {
                jobIds = userApplicationsRepository.findById(requestModel.getPhoneNumber()).get().getJobId();
                log.info("Retrieved Job Ids {}",jobIds);
            }
        }
        jobIds.add(requestModel.getJobId());
        return UserModel.builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .userEmail(requestModel.getUserEmail())
                .phoneNumber(requestModel.getPhoneNumber())
                .primarySkills(requestModel.getPrimarySkills())
                .jobId(jobIds).build();
    }

    public List<UserModel> getAllUsers() {
        return userApplicationsRepository.findAll();
    }

    public List<UserList> getUserList(){
        List<UserList> modelList = new ArrayList<>();
        for (UserModel m:getAllUsers()) {
            Set<JobModel> jobModels=getJobModels(m.getJobId());
            UserList userList = UserList.builder()
                    .userEmail(m.getUserEmail())
                    .firstName(m.getFirstName())
                    .lastName(m.getLastName())
                    .phoneNumber(m.getPhoneNumber())
                    .primarySkills(m.getPrimarySkills())
                    .jobId(jobModels)
                    .build();
            modelList.add(userList);
        }
        return modelList;
    }

    private Set<JobModel> getJobModels(Set<Long> ids){
        Set<JobModel> jobModels = new HashSet<>();
        for (Long id:ids) {
            jobModels.add(jobRepository.findById(id).get());
        }
        return jobModels;
    }

}
