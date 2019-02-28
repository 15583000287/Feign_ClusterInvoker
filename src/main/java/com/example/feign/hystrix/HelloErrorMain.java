package com.example.feign.hystrix;

/**
 * 调用的“errorHello”服务，会阻塞 10 秒才有返回。
 * 默认情况下，如果调用的 Web 服务无法在 1 秒内完成，那么将会触发回退。
 */
public class HelloErrorMain {
    public static void main(String[] args) {
        // 请求异常的服务
        String errorUrl = "http://localhost:8080/errorHello";
        HelloCommand command = new HelloCommand(errorUrl);
        String result = command.execute();
        System.out.println("请求异常的服务，结果：" + result);
    }
}
