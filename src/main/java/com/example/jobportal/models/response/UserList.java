package com.example.jobportal.models.response;

import com.example.jobportal.models.JobModel;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {

    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    @Id
    private String phoneNumber;
    private List<String> primarySkills;
    @NonNull
    private Set<JobModel> jobId;

}
