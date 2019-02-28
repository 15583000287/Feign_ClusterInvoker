package com.example.feign.feign_hystrix;

import com.example.feign.entity.User;
import com.example.feign.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/getuser/{userId}")
    public User getUser(@PathVariable("userId")Integer userId){
        System.out.println(userId);
        return userFeignClient.getUser(userId);
    }
}
