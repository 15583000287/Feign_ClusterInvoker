package com.example.feign.feign;

import com.example.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class InvokeController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/user/{userId}")
    public User getUser(@PathVariable("userId")Integer userId){
        System.out.println(userId);
        return userClient.getUser(userId);
    }
}
