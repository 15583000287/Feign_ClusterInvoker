package com.example.feign.feign_hystrix;

import com.example.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign的fallback测试
 * 使用@FeignClient的fallback属性指定回退类，回退类实现此接口 （当请求发送异常时，执行回退类的重写方法）
 */
@FeignClient(value = "service-provider",fallback = FeignClientFallback.class)
public interface UserFeignClient {
    @RequestMapping("/getuser/{userId}")
    User getUser(@RequestParam("userId") Integer userId);
}
