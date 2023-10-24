package com.example.jobportal.repository;

import com.example.jobportal.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*****
 * The repository layer containing information about users and the jobs they applied.
 * **/
@Repository
public interface UserApplicationsRepository extends JpaRepository<UserModel, String> {

}
