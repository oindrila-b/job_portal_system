package com.example.jobportal.models;

import lombok.*;

import java.io.File;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private String userName;
    @NonNull
    private String userEmail;
    @NonNull
    private String phoneNumber;
    private List<String> primarySkills;
    @NonNull
    private File resume;
    private Long jobId;


}
