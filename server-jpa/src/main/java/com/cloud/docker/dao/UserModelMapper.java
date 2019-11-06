package com.cloud.docker.dao;

import com.cloud.docker.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelMapper extends JpaRepository<UserModel, Long> {
}