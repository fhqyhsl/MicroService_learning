package zyx.helloservice.service;

import org.springframework.stereotype.Service;


    @Service
    public class HelloService {
        public String getName() {
            return "hello";
        }
    public String sayHello(String name) {
            return "hello " + name;
    }
    }

