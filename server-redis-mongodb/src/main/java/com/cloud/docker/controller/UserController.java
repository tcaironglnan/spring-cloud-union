package com.cloud.docker.controller;

import com.cloud.docker.dao.MongoMapper;
import com.cloud.docker.dao.UserRepository;
import com.cloud.docker.model.City;
import com.cloud.docker.model.User;
import com.cloud.docker.service.CityService;
import com.cloud.docker.service.UserService;
import com.cloud.docker.tools.Page;
import com.cloud.docker.tools.ToolJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @Created 2019-10-08 17:27
 **/
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;
    @Autowired
    private MongoMapper mongoMapper;

    //region mongodb 部分
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        User save = mongoMapper.save(user);
        return save;
    }

    @GetMapping("/findAll")
    public Object findALL() {
        List<User> all = mongoMapper.findAll();
        return all;
    }

    @GetMapping("/deleteById")
    public String deleteById(@RequestParam Long id) {
        mongoMapper.deleteById(id);
        return "success";
    }

    @GetMapping("/count")
    public Object count() {
        long count = mongoMapper.count();
        return count;
    }

    @PostMapping("/update")
    public Object update(@RequestBody User user) {
        User save = mongoMapper.save(user);
        return save;
    }
    //endregion

    //region redis部分
    @GetMapping("/user_redis/{id}")
    public String index(@PathVariable("id") Long id) {
        long beginTime = System.currentTimeMillis();
        User user = userService.selectByPrimaryKey(id);
        long time = System.currentTimeMillis() - beginTime;
        logger.info("消耗查询时间：{}", time);
        return "Hello SpringBoot" + user.getName() + ",消耗查询时间：" + time;
    }

    //endregion

    //region 其它
    /**
     * 该方法还存在接收json参数为空的问题
     *
     * @param user
     * @param currentPage
     * @param pageSize
     * @return
     */
    @PostMapping("/search")
    public String search(@RequestBody User user, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {

        if (user.getName() == null || user.getName().length() < 1) {
            user.setName("");
        }
        Page<City> page = cityService.search(user.getName(), currentPage, pageSize);
        return ToolJson.anyToJson(page);
    }

    /**
     * 求情方式是form-data
     *
     * @param name
     * @param pageSize
     * @param currentPage
     * @return
     */
    @PostMapping("/query")
    public String query(@RequestParam String name, @RequestParam Integer pageSize, @RequestParam Integer currentPage) {

        if (name == null || name.length() < 1) {
            name = "";
        }
        Page<City> page = cityService.search(name, currentPage, pageSize);
        return ToolJson.anyToJson(page);
    }

    /**
     * 求情方式是form-data
     *
     * @param name
     * @param pageSize
     * @param currentPage
     * @return
     */
    @PostMapping("/searchByName")
    public Page<City> searchByName(@RequestParam String name, @RequestParam Integer pageSize, @RequestParam Integer currentPage) {

        if (name == null || name.length() < 1) {
            name = "";
        }
        Page<City> page = cityService.search(name, currentPage, pageSize);
        return page;
    }

    @PostMapping("/findUser")
    public User findUser(@RequestBody User user) {
        logger.info("current data is: {}", user);
        User one = userRepository.findOne(user.getId());
        return one;
    }

    @PostMapping("/user/findUser")
    public User findOfUser(@RequestBody User user) {
        logger.info("current data is: {}", user);
        User one = userRepository.findOne(user.getId());
        return one;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public User insertUser(@RequestBody User user) {
        logger.info("current data is: {}", user);
        int count = userRepository.getCount();
        BigDecimal totalAmount = new BigDecimal(count);
        totalAmount = totalAmount.add(new BigDecimal(count + 1));
        user.setBalance(totalAmount)
                .setUsername(user.getUsername() + count)
                .setName(user.getName() + count)
                .setAge(count + user.getAge());
        //返回插入数据的主键,但不是接收到的one,因为one一直默认返回的1,暂且认为这是插入成功的标志
        //返回的主键赋给user实体里的id了,需要获取的话就需要单独user.getId()获取
        int one = userRepository.insertUser(user);
        User repositoryOne = userRepository.findOne(user.getId());
        return repositoryOne;
    }

    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    public User findUserById(@RequestParam Long id) {
        logger.info("current data is: {}", id);
        User one = userRepository.findOne(id);
        return one;
    }

    @GetMapping("/get")
    public User get(@RequestParam Long id, @RequestParam String username) {
        logger.info("id is :{},username is :{}", id, username);
        return userRepository.findOne(id);
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam Map map) {
        logger.info("map is :{}", map);
        return userRepository.findOne(Long.parseLong(map.get("id").toString()));
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User one = userRepository.findOne(id);
        return one;
    }

    @GetMapping("/user/{id}")
    public User findUserByUserId(@PathVariable Long id) {
        User one = userRepository.findOne(id);
        return one;
    }
    //endregion
}
