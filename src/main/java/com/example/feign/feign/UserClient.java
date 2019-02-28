package com.example.feign.feign;

import com.example.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign 实际上会帮我们动态生成代理类。
 * Feign 使用的是 JDK 的动态代理，生成的代理类，会将请求的信息封装，交给 feign.Client 接口发送请求，
 * 而该接口的默认实现类，最终会使用 java.net.HttpURLConnection
 *
 *
 * Feign负载均衡
 * Spring Cloud 实现的 Feign 客户端，类名为 LoadBalancerFeignClient，
 * 在该类中，维护着与 SpringClientFactory 相关的实例，通过 SpringClientFactory 可以获取负载均衡器，
 * 负载均衡器会根据一定的规则来选取处理请求的服务器，最终实现负载均衡的功能。接下来，
 * 调用“服务提供者”的“/user/{userId}”服务来测试负载均衡
 */

@FeignClient("SERVICE-PROVIDER") //指定服务,不区分大小写
public interface UserClient {
    @RequestMapping("/user/{userId}") //绑定服务端提供的REST服务 到接口
    User getUser(@RequestParam("userId") Integer id); //通过@RequestParma获取参数,生成的动态代理将请求信息封装    将参数id封装到/user/{userId}
}
