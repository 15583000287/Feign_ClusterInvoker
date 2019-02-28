package com.example.feign.ribbon_hystrix;

import com.example.feign.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     *@HystrixCommand 注解
     * fallbackMethod指定回退方法
     * 注意:回退方法返回类型与@HystrixCommand注解修饰的方法一致
     */
    @HystrixCommand(fallbackMethod = "error")
    public User getUser(String id){
        return restTemplate.getForObject("http://localhost:8080/user/"+id ,User.class); //User.class 指定返回值类型
    }

    /**
     * 回退方法
     * 注意：回退方法返回值类型与@HystrixCommand注解修饰的方法一致
     */
    public User error(String id) {
        User user = new User();
        user.setId(-1);
        user.setMessage("Error, 执行回退方法！");
        //return "(id ="+id+") 异常，执行回退方法!";
        return user;
    }

}
