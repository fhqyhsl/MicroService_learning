package zyx.contentservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import zyx.contentservice.Config.RandomLoadBalancerConfig;

@SpringBootApplication
@MapperScan("zyx.contentservice.Mapper")
@EnableFeignClients(basePackages = "zyx.contentservice.OpenFeign")
@LoadBalancerClient(name="user-service",configuration= RandomLoadBalancerConfig.class)
public class ContentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentServiceApplication.class, args);
    }

}
