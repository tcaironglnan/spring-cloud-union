package com.cloud.docker.service;

import com.cloud.docker.model.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-22 14:48
 **/
public interface UserService {

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    List<User> saveUserOfList(List<User> users);

    List<User> getUserList();

    User findUserById(Long id);

    User findUserByName(String name);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    User save(User user);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    User delete(User user);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3600, rollbackFor = Exception.class)
    User update(User user);
}
