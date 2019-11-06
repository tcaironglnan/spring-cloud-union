package com.cloud.docker.controller;

import com.cloud.docker.model.User;
import com.cloud.docker.service.UserService;
import com.cloud.docker.tools.ToolJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lenovo
 * @Created 2019-10-08 17:27
 **/
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/saveUserOfList")
    public List<User> saveUserOfList(@RequestBody List<User> users) {
        return userService.saveUserOfList(users);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) {
        User one = userService.findUserById(id);
        return one;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getUserList();
    }

    @PostMapping("/delete")
    public User delete(@RequestBody User user) {
        //ID为必填项,否则删除失败
        User delete = userService.delete(user);
        return delete;
    }

    @GetMapping("/findUserByName")
    public User findUserByName(@RequestParam String name) {
        User userByName = userService.findUserByName(name);
        return userByName;
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        //ID必填项,否则修改失败,并且如果ID为不存在的ID,则会新增一条数据
        //可依据此先做判断
        User update = userService.update(user);
        return update;
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        User save = userService.save(user);
        return save;
    }
}
