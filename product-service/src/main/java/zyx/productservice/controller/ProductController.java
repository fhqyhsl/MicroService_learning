package zyx.productservice.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
    @GetMapping("/product")
    public String getProductInfo(@RequestParam String productId) {
        return "产品信息: " + productId;
    }

}
