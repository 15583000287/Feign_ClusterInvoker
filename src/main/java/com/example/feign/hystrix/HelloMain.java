package com.example.feign.hystrix;

import com.netflix.config.ConfigurationManager;
import org.springframework.cloud.openfeign.support.FallbackCommand;

public class HelloMain {
    public static void main(String[] args) {
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen", "true");
        // 请求正常的服务
        String normalUrl = "http://localhost:8080/normalHello";
        HelloCommand command = new HelloCommand(normalUrl);
        String result = command.execute();
        System.out.println("请求正常的服务，结果：" + result);
    }
}
