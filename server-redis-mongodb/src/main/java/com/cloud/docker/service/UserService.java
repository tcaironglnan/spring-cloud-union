package com.cloud.docker.service;

import com.cloud.docker.model.User;
import com.cloud.docker.model.UserModel;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-22 14:48
 **/
public interface UserService {

    User selectByPrimaryKey(Long id);

    List<UserModel> getUserList();
}
