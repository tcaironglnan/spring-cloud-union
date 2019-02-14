package com.client.service.impl;

import com.client.dao.UserModelMapper;
import com.client.model.UserModel;
import com.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-01 14:33
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public List<UserModel> getUserList(UserModel userModel) {

        return userModelMapper.getUserList(userModel);
    }
}
