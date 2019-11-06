package com.cloud.docker.dao;

import com.cloud.docker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Lenovo
 * @Created 2019-11-01 下午2:47
 **/
@Component
public interface MongoMapper extends MongoRepository<User,String> {
    List<User> findAllByUsernameLike(String userName);

    void deleteById(Long id);
}
