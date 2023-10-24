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
    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String phoneNumber;
    private List<String> primarySkills;
    private Long jobId;

}
