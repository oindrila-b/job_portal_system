package com.example.jobportal.service;

import com.example.jobportal.exceptions.JobNotFoundException;
import com.example.jobportal.exceptions.RequestParameterNullException;
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

/*****
 *  The service layer for all user related processing. This class is responsible
 *   for application of a new user, getting all the user, creating user model.
 * **/
@Service
@Slf4j
public class UserService {
    /***
     * The repository has access to the job table in the database
     * **/
    @Autowired
    JobRepository jobRepository;
    /***
     * The repository has access to the job table in the database
     * **/
    @Autowired
    UserApplicationsRepository userApplicationsRepository;

    /*****
     * This method is used by the user to apply to a new job . It takes the request
     * model, creates a User Model and the persists in the database.
     * @param requestModel the model that goes created to UserModel to get persisted.
     * @throws JobNotFoundException
     * @throws RequestParameterNullException
     * **/
    public Long applyToJob(UserApplicationRequestModel requestModel) throws JobNotFoundException, RequestParameterNullException {
        if (requestModel.getUserEmail().isEmpty() || requestModel.getFirstName().isEmpty()||
        requestModel.getLastName().isEmpty() || requestModel.getPhoneNumber().isEmpty()||
            requestModel.getPrimarySkills().isEmpty() || requestModel.getJobId() == null) {
            throw new RequestParameterNullException("Request Parameters are Null");
        }
            UserModel model = createUserModel(requestModel);
       UserModel user=  userApplicationsRepository.save(model);
        log.info("User Application Details :  {} " , 1 );
        return requestModel.getJobId();
    }

    /***
     * Withdraws application from the database by deleting the entry.
     * @param phoneNumber to delete a user application based on entry
     * **/
    public void withdrawApplication(String phoneNumber) {
        userApplicationsRepository.deleteById(phoneNumber);
        log.info("User Application with phone NUmber {} Deleted. " , phoneNumber );
    }

    /******
     * This method is used to create a user model from a request sent by the client.
     * @param requestModel the model that goes created to UserModel.
     * @return UserModel
     * **/
    private UserModel createUserModel(UserApplicationRequestModel requestModel) throws JobNotFoundException {
        List<JobModel> jobIds = new ArrayList<>();
        if (jobRepository.findById(requestModel.getJobId()).isEmpty()) {
            throw new JobNotFoundException(requestModel.getJobId());
        }
        if (userApplicationsRepository.existsById(requestModel.getPhoneNumber())) {
            log.info("User with phone number {} exists", requestModel.getPhoneNumber());
            if (userApplicationsRepository.findById(requestModel.getPhoneNumber()).isPresent()) {
                jobIds = userApplicationsRepository.findById(requestModel.getPhoneNumber()).get().getJobModels();
                log.info("Retrieved Job Ids {}",jobIds);
            }
        }
        jobIds.add(getJobModel(requestModel.getJobId()));
        return UserModel.builder()
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .userEmail(requestModel.getUserEmail())
                .phoneNumber(requestModel.getPhoneNumber())
                .primarySkills(requestModel.getPrimarySkills())
                .jobModels(jobIds).build();
    }

    /****
     * This method gets a list of UserModels persisted in the database.
     * **/
    private List<UserModel> getAllUsers() {
        return userApplicationsRepository.findAll();
    }


    /****
     * This method gets a list of UserList persisted in the database.
     * **/
    public List<UserList> getUserList(){
        List<UserList> modelList = new ArrayList<>();
        for (UserModel m:getAllUsers()) {
            List<JobModel> jobModels= m.getJobModels();
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

    private List<JobModel> getJobModels(List<Long> ids){
        List<JobModel> jobModels = new ArrayList<>();
        for (Long id:ids) {
            jobModels.add(jobRepository.findById(id).get());
        }
        return jobModels;
    }

    /***
     *  Retrieves a Job Model object based on the given ID
     * ***/
    private JobModel getJobModel(Long jobId) {
        return jobRepository.findById(jobId).get();
    }

}
