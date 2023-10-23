package com.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String phoneNumber;
    private List<String> primarySkills;
    @NonNull
    @OneToMany(mappedBy = "userModel")
    private Set<JobModel> jobId = new HashSet<>();

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", primarySkills=" + primarySkills +
                ", jobId=" + jobId +
                '}';
    }
}
