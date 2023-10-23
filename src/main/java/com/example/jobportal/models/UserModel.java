package com.example.jobportal.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {

    private String firstName;
    private String lastName;
    @NonNull
    private String userEmail;
    @NonNull
    @Id
    private String phoneNumber;
    private List<String> primarySkills;
    //    @NonNull
//    private MultipartFile resume;
    @NonNull
    private Set<Long> jobId;

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
