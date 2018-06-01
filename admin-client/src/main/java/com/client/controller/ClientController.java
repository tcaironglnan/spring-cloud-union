package com.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FaceFeel
 * @Created 2018-05-23 10:52
 **/
@RestController
public class ClientController {

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
