package com.cloud.docker.service.impl;

import com.cloud.docker.service.UserSerive;
import com.cloud.docker.dao.UserModelMapper;
import com.cloud.docker.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-22 14:49
 **/
@Service("userService")
public class UserServiceImpl implements UserSerive {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public List<UserModel> getUserList() {
        return userModelMapper.getUserList();
    }
}
