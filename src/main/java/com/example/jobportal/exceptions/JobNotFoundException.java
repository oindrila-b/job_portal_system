package com.example.jobportal.exceptions;

/****
 * This exception is thrown when the ID of the job doesn't
 * match with any jobId in the database.
 * **/
public class JobNotFoundException extends Exception{
    public JobNotFoundException(Long id) {
        System.out.printf("Job with id %d not found", id);
    }
}