package zyx.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class AiController
{

    @Autowired
    private RestTemplate restTemplate;

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
}