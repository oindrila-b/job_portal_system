package com.example.jobportal.repository;

import com.example.jobportal.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationsRepository extends JpaRepository<UserModel, String> {

}
