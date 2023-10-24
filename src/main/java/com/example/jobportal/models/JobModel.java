package com.example.jobportal.models;

import com.example.jobportal.enums.JobType;
import com.example.jobportal.enums.WorkModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/****
 * This is the Job Entity that gets saved in the database.
 * **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_model")
public class JobModel {

    /**
     *  Parameter to store Job ID.
     * Is also the unique identifier for all the Jobs.
     * */
    @Id
    @Column(name = "ID")
    private Long jobId;
    /**
     *  Parameter to store the Job title
     * */
    private String jobTitle;
    /**
     *  Parameter to store the Job Description
     * */
    @Column(length = 65555)
    private String jobDescription;
    /**
     *  Parameter to store the Job Location
     * */
    private String jobLocation;
    /**
     *  Parameter to store the Company Name.
     * */
    private String companyName;
    /**
     *  Parameter to store the Skills required in a Job in the form of a list.
     * */
    private List<String> requiredSkills;
    /**
     *  Parameter to store the Job Type
     * */
    private JobType jobType;
    /**
     *  Parameter to store the Work Model
     * */
    private WorkModel workModel;

    /****
     * Prints out the Job Model Object is a string form.
     * **/
    @Override
    public String toString() {
        return "JobModel{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", requiredSkills=" + requiredSkills +
                ", jobType=" + jobType +
                ", companyName=" +companyName+
                ", workModel=" + workModel +
                '}';
    }
}
