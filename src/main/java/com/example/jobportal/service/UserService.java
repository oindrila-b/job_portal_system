package com.example.jobportal.service;

import com.example.jobportal.models.JobModel;
import com.example.jobportal.models.UserModel;
import com.example.jobportal.repository.UserApplicationsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserApplicationsRepository userApplicationsRepository;

    public Long applyToJob(UserModel userModel) {
       UserModel user=  userApplicationsRepository.save(userModel);
        log.info("User Application Details :  {} " , user );
        return user.getJobId().getJobId();
    }

    public void withdrawApplication(String phoneNumber) {
        userApplicationsRepository.deleteById(phoneNumber);
        log.info("User Application with phone NUmber {} Deleted. " , phoneNumber );
    }
}
