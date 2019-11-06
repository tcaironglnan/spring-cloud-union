package com.cloud.docker.dao;

import com.cloud.docker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lenovo
 * @Created 2019-10-08 17:25
 **/
//@Repository("userRepository")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
