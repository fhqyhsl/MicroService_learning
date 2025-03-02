package zyx.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import zyx.userservice.Service.UserService;
import zyx.userservice.entity.User;
@Slf4j
@RestController
@RequestMapping("/user")
public class AiController
{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/ask-ai")
    public String askAI(@RequestBody String question) {
        try {
            // AI 服务的 URL
            String aiServiceUrl = "http://localhost:8080/ai/ask";

            // 调用 AI 服务的 /ai/ask 接口
            String response = restTemplate.postForObject(aiServiceUrl, question, String.class);

            // 返回 AI 服务的响应
            return "AI 回答: " + response;
        } catch (Exception e) {
            e.printStackTrace();
            return "调用 AI 服务失败: " + e.getMessage();
        }
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        log.info("用户被调用！");
        return userService.getById(id);
    }
}