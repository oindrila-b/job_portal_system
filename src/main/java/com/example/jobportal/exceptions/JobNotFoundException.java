package com.example.jobportal.exceptions;

/****
 * This exception is thrown when the ID of the job doesn't
 * match with any jobId in the database.
 * **/
public class JobNotFoundException extends Exception{
    /***
     *  Calls super to throw exception.
     * @param id for the job id that wasn't found
     * */
    public JobNotFoundException(Long id) {
        System.out.printf("Job with id %d not found", id);
    }
}