package com.cloud.docker.service.impl;

import com.cloud.docker.dao.UserModelMapper;
import com.cloud.docker.dao.UserRepository;
import com.cloud.docker.model.User;
import com.cloud.docker.model.UserModel;
import com.cloud.docker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 注解Cacheable可以标记在一个方法上，也可以标记在一个类上。当标记在一个方法上时表示该方法
 * 是支持缓存的， 当标记在一个类上时则表示该类所有的方法都是支持缓存的。对于一个支持缓存的方法，
 * Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接
 * 从缓存中获取结果，而不需要再次执行该方法。
 * 使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
 * 如果存在就不再执行该方法而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
 * @author FaceFeel
 * @Created 2018-05-22 14:49
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserModelMapper userModelMapper;
    @Autowired
    private UserRepository userRepository;

    //以下方式的其它参数由缓存管理器来设置
    @Cacheable(value="user", key="'user'")
    //以下方式自定义缓存过期时间和自动刷新缓存时间
    //value属性上用#号隔开，第一个是原始的缓存容器名称，
    // 第二个是缓存的有效时间，第三个是缓存的自动刷新时间，单位都是秒。
//    @Cacheable(value = "user#120#90", key = "#id") //#id中的id类型必须为String类型
//    @Cacheable(value = "user#120#90", key = "'user'")
    //缓存的有效时间和自动刷新时间支持SpEl表达式，支持在配置文件中配置, #id中的id类型必须为String类型
//    @Cacheable(value = "user#${select.cache.timeout:180}#${select.cache.refresh:60}", key = "'docker'", sync = true)
    //以下方式为指定触发缓存的条件: 表示只有当user的id为偶数时才会进行缓存
//    @Cacheable(value={"users"}, key="#user.id", condition="#user.id%2==0")
    //以下方式为不缓存null值
//    @Cacheable(key = "''+#id", unless="#result == null")
    @Override
    public User selectByPrimaryKey(Long id) {
        logger.info("开始查询.....");
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("查询结束......");
        return userRepository.findOne(id);
    }

    @Override
    public List<UserModel> getUserList() {
        return userModelMapper.getUserList();
    }
}
