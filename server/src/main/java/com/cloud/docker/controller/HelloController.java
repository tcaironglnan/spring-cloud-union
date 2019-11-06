package com.cloud.docker.controller;

import com.cloud.docker.service.CityService;
import com.cloud.docker.service.UserSerive;
import com.cloud.docker.model.City;
import com.cloud.docker.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController  //该注解相当于:@RequestMapping+@ResponseBody
@RequestMapping("/")
public class HelloController {

    @Autowired
    private CityService service;
    @Autowired
    private UserSerive userSerive;

    @RequestMapping("showUser")
    public String show(HttpServletRequest request){
        List<UserModel> userList = userSerive.getUserList();
        request.setAttribute("user",userList);
        return "show";
    }

    @RequestMapping("find")
    public String findAll(ModelMap model){

        List<City> all = service.findAll();
        model.addAttribute("all",all);
        return "hello";
    }

    @RequestMapping("hello1")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }
}