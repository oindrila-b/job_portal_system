package com.example.jobportal.models.response;

import com.example.jobportal.models.JobModel;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
/*****
 * This class represents the User List persisted in the database, with embedded Job Models.
 * **/
public class UserList {

    /**
     *  Parameter to store user's first name
     * */
    private String firstName;
    /**
     *  Parameter to store user's last name
     * */
    private String lastName;
    /**
     *  Parameter to store user's email
     * */
    @NonNull
    private String userEmail;
    /**
     *  Parameter to store user's phoneNumber
     * */
    @NonNull
    private String phoneNumber;
    /**
     *  Parameter to store user's Primary Skills as a list
     * */
    private List<String> primarySkills;
    /**
     *  Parameter to store the List of Job Models the user has applied to
     * */
    @NonNull
    private List<JobModel> jobId;

}
