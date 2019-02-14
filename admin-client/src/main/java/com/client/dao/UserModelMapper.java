package com.client.dao;

import com.client.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-06-01 14:31
 **/
@Repository("userModelMapper")
public interface UserModelMapper {

    List<UserModel> getUserList(UserModel userModel);
}
