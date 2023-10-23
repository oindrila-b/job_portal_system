package com.example.jobportal.entities;

import com.example.jobportal.enums.JobType;
import com.example.jobportal.enums.WorkModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_model")
public class JobModel {

    @Id
    @Column(name = "ID")
    private Long jobId;
    private String jobTitle;
    @Column(length = 65555)
    private String jobDescription;
    private String jobLocation;
    private String companyName;
    private List<String> requiredSkills;
    private JobType jobType;
    private WorkModel workModel;
    @ManyToOne
     @JoinColumn(name="user")
    UserModel userModel;

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
