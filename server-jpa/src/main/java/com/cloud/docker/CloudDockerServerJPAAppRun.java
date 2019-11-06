package com.cloud.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author FaceFeel
 * @Created 2018-04-17 11:23
 **/
@SpringBootApplication
@EnableEurekaClient
public class CloudDockerServerJPAAppRun {
    public static void main(String[] args) {
        //项目启动:mvn spring-boot:run
        SpringApplication.run(CloudDockerServerJPAAppRun.class,args);
    }
}
