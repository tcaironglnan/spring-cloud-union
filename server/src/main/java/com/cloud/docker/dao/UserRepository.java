package com.cloud.docker.dao;

import com.cloud.docker.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Lenovo
 * @Created 2019-10-08 17:25
 **/
@Repository("userRepository")
public interface UserRepository {

    User findOne(Long id);

    int insertUser(User user);

    void insertOfUser(User user);

    int getCount();
}
