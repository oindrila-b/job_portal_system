package com.example.jobportal.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/****
 * This is the Entity that gets saved in the database.
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UserModel {

    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    @Id
    private String phoneNumber;
    private List<String> primarySkills;

    @NonNull
    @OneToMany
    @JoinColumn(name="jobs")
    private List<JobModel> jobModels;

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", primarySkills=" + primarySkills +
                ", jobId=" + jobModels +
                '}';
    }
}
