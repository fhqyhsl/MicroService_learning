package zyx.contentservice.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/user")
public interface UserFeignClient {
    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Integer id);
}
