package com.client.controller;

import com.client.model.UserModel;
import com.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author FaceFeel
 * @Created 2018-05-23 10:52
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String index(HttpServletRequest request){

        List<UserModel> userList = userService.getUserList(new UserModel());
        request.setAttribute("user",userList);
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(String name) {
        return "Hello Eureka " + name;
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
}
