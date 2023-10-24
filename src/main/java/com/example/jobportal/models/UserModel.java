package com.example.jobportal.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
/****
 * This is the User Entity that gets saved in the database.
 * **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UserModel {

    /**
     *  Parameter to store user's first name
     * */
    private String firstName;
    /**
     *  Parameter to store user's last name
     * */
    private String lastName;
    /**
     *  Parameter to store user's email, cannot be null
     * */
    @NonNull
    private String userEmail;
    @NonNull
    @Id
    /**
     *  Parameter to store user's phoneNumber, also the unique identifier for the user table.
     *  Cannot be null.
     * */
    private String phoneNumber;
    /**
     *  Parameter to store user's primary skills in the form of a list
     * */
    private List<String> primarySkills;

    /**
     *  Parameter to store the list of job models
     *  representing the jobs that the user has applied to.
     * */
    @NonNull
    @OneToMany
    @JoinColumn(name="jobs")
    private List<JobModel> jobModels;

    /****
     * Prints out the User Model Object is a string form.
     * **/
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
