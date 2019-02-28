package com.example.feign.feign_hystrix;

import com.example.feign.entity.User;
import org.springframework.stereotype.Component;

/**
 * 回退类FeignClientFallback需实现Feign Client接口（即 UserFeignClient接口）
 * FeignClientFallback也可以是public class，没有区别
 */
@Component
public class FeignClientFallback implements UserFeignClient {

    @Override
    public User getUser(Integer userId) {
        User user = new User();
        user.setId(-1);
        user.setUsername("root");
        user.setPassword("123");
        user.setMessage("执行了回退（fallback）方法！");
        return user;
    }
}
