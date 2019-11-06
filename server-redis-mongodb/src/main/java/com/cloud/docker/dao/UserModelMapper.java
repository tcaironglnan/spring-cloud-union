package com.cloud.docker.dao;

import com.cloud.docker.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userModelMapper")
public interface UserModelMapper {
    List<UserModel> getUserList();
}