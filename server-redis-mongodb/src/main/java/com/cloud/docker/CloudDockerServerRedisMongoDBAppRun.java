package com.cloud.docker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author FaceFeel
 * @Created 2018-04-17 11:23
 **/
@SpringBootApplication
@EnableEurekaClient
//将项目中对应的mapper接口的路径加进来就可以了
@MapperScan("com.cloud.docker.dao")
//@ComponentScan(basePackages = "com.springboot.dao")
public class CloudDockerServerRedisMongoDBAppRun {
    public static void main(String[] args) {
        //项目启动:mvn spring-boot:run
        SpringApplication.run(CloudDockerServerRedisMongoDBAppRun.class,args);
    }
}
