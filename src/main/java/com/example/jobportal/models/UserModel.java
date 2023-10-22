package com.example.jobportal.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {

    private String userName;
    @NonNull
    private String userEmail;
    @NonNull
    @Id
    private String phoneNumber;
    private List<String> primarySkills;
    @NonNull
    private File resume;
    @NonNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id", referencedColumnName = "ID")
    private JobModel jobId;

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", primarySkills=" + primarySkills +
                ", resume=" + resume +
                ", jobId=" + jobId +
                '}';
    }
}
