package com.cloud.docker.service.impl;

import com.cloud.docker.dao.UserRepository;
import com.cloud.docker.model.User;
import com.cloud.docker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-22 14:49
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> saveUserOfList(List<User> users) {
        List<User> save = userRepository.save(users);
        return save;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserByName(String name) {
        User user = new User().setName(name);
        return userRepository.findOne(Example.of(user));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(User user) {
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }
}
