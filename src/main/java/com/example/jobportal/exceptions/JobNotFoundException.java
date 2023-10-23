package com.example.jobportal.exceptions;

public class JobNotFoundException extends Exception{
    public JobNotFoundException(Long id) {
        System.out.printf("Job with id %d not found", id);
    }
}