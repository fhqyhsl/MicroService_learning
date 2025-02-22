package zyx.orderservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder(@RequestParam String username, @RequestParam String productId,@RequestParam String orderId) {
        // 调用用户服务获取用户信息
        String userServiceUrl = "http://localhost:8081/user?username=" + username;
        String userInfo = restTemplate.getForObject(userServiceUrl, String.class);

        // 调用产品服务获取产品信息
        String productServiceUrl = "http://localhost:8083/product?productId=" + productId;
        String productInfo = restTemplate.getForObject(productServiceUrl, String.class);

        // 调用产品服务获取产品信息
        String orderServiceUrl = "http://localhost:8082/product?orderId=" + orderId;
        String orderInfo = restTemplate.getForObject(productServiceUrl, String.class);

        // 返回完整的订单信息
        return "订单 ID: "+orderId+" ,下单人: " + userInfo + ", 商品信息: " + productInfo;
    }
}
