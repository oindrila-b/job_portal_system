package com.example.jobportal.models;

import com.example.jobportal.enums.JobType;
import com.example.jobportal.enums.WorkModel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobModel {

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private List<String> requiredSkills;
    private JobType jobType;
    private WorkModel workModel;

}
