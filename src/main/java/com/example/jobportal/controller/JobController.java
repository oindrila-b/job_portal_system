package com.example.jobportal.controller;

import com.example.jobportal.exceptions.JobNotFoundException;
import com.example.jobportal.models.JobModel;
import com.example.jobportal.models.UserModel;
import com.example.jobportal.models.request.UserApplicationRequestModel;
import com.example.jobportal.models.response.UserList;
import com.example.jobportal.service.JobService;
import com.example.jobportal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****
 * This is the controller class that maps the incoming requests from
 *  http://localhost:3000 to the api/v1/jobs endpoint. Each request is mapped to a
 *  specific method, depending on the Type of request.
 *
 * */
@RestController
@RequestMapping("api/v1/jobs")
@Slf4j
@CrossOrigin("http://localhost:3000")
public class JobController {

    /***
     *  The parameters that gives access to the JobService class
     * **/
    @Autowired
    JobService jobService;

    /***
     *  The parameters that gives access to the UserService class
     * **/
    @Autowired
    UserService userService;

    /***
     *  Maps the POST request to add a new job entry in the database.
     * @param jobModel The Job Entry to be added in the database
     * @return Long The ID of the job that was added
     * **/
    @PostMapping(path = "add-job")
    public Long addJob(@RequestBody JobModel jobModel) {
        return jobService.addJob(jobModel);
    }

    /***
     *  Maps the GET request to get a list of all the jobs in a database.
     * @return List<JobModel> A list of all the Job Entries present in the database.
     * **/
    @GetMapping
    public ResponseEntity<List<JobModel>> getJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(),HttpStatus.OK);
    }

    /***
     *  Maps the POST request to add a new job entry in the database.
     * @param requestModel The request entity from the client side for a client to apply to the job.
     * @throws Exception
     * **/
    @PostMapping("/apply")
    public void applyToJob(@RequestBody UserApplicationRequestModel requestModel) throws Exception {
        Long id = userService.applyToJob(requestModel);
        log.info("Applied to job : {} ", id );
    }

    /***
     *  Maps the GET request to get a list of all the users in a database.
     * @return List<UserList> A list of all the User Entries present in the database.
     * **/
    @GetMapping(path = "/usersList")
    public ResponseEntity<List<UserList>> getUsers() {
        return new ResponseEntity<>(userService.getUserList(),HttpStatus.OK);
    }


}
