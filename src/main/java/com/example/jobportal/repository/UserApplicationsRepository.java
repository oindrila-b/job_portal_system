package com.example.jobportal.repository;

import com.example.jobportal.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationsRepository extends JpaRepository<UserModel, Long> {
    UserModel findByPhoneNumber(String phoneNumber);
    boolean existsByPhoneNumber(String phoneNumber);
    void deleteByPhoneNumber(String phoneNumber);
}
