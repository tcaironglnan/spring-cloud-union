package com.client.service;

import com.client.model.UserModel;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-01 14:33
 **/
public interface UserService {
    List<UserModel> getUserList(UserModel userModel);
}
