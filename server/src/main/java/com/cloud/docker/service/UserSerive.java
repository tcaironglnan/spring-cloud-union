package com.cloud.docker.service;

import com.cloud.docker.model.UserModel;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-22 14:48
 **/
public interface UserSerive {

    List<UserModel> getUserList();
}
