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

@RestController
@RequestMapping("api/v1/jobs")
@Slf4j
@CrossOrigin("http://localhost:3000")
public class JobController {

    @Autowired
    JobService jobService;
    @Autowired
    UserService userService;

    @PostMapping(path = "add-job")
    public Long addJob(@RequestBody JobModel jobModel) {
        return jobService.addJob(jobModel);
    }

    //    @DeleteMapping(path="/{id}")
//    public void deleteById(@PathVariable("id")Long id) {
//        jobService.deleteById(id);
//    }

    @GetMapping
    public ResponseEntity<List<JobModel>> getJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(),HttpStatus.OK);
    }

    @PostMapping("/apply")
    public void applyToJob(@RequestBody UserApplicationRequestModel requestModel) throws JobNotFoundException {
        Long id = userService.applyToJob(requestModel);
        log.info("Applied to job : {} ", id );
    }

    @GetMapping(path = "/usersList")
    public ResponseEntity<List<UserList>> getUsers() {
        return new ResponseEntity<>(userService.getUserList(),HttpStatus.OK);
    }


}
