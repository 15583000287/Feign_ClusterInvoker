package com.example.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient //有发现服务的能力
@EnableFeignClients //打开Feign开关
@EnableHystrix //开启断路器 Hystrix (Ribbon方式实现断路器)
@EnableSwagger2
@EnableHystrixDashboard /*提供监控注解  开启HystrixDashboard*/
@EnableCircuitBreaker //开启断路器功能
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Bean  //@Bean 用在方法上，产生一个Bean，并且交给Spring容器管理
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
