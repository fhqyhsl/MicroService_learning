package zyx.requestservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zyx.requestservice.openfeign.HelloService;

@RestController
public class ConsumerController4 {
    @Resource
    private HelloService helloService;
    @GetMapping("/sayhello")
    private String sayHello(@RequestParam String name) {
        return helloService.sayHello(name);
    }
}
