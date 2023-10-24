package com.example.jobportal.models.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.List;

/****
 * This class represents the JSON request that the control  ler would accept
 * and create a UserModel to persist in the database.
 * **/

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserApplicationRequestModel {
    /**
     *  Parameter to store user's first name
     * */
    private String firstName;
    /**
     *  Parameter to store user's last name
     * */
    private String lastName;
    /**
     *  Parameter to store user's  email
     * */
    @NonNull
    private String userEmail;
    /**
     *  Parameter to store user's phoneNubmer
     * */
    @NonNull
    private String phoneNumber;
    /**
     *  Parameter to store user's Primary Skills
     * */
    private List<String> primarySkills;
    /**
     *  Parameter to store the list of job ids
     *  representing the jobs that the user has applied to.
     * */
    private Long jobId;

}
