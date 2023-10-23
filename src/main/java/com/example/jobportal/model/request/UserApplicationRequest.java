package com.example.jobportal.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicationRequest {
    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    private String phoneNumber;
    private List<String> primarySkills;
    private Long jobId;

}
