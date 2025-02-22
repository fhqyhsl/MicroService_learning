package zyx.nodeservice.controller;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.exception.InputRequiredException;
import zyx.nodeservice.Main;

@RestController
@RequestMapping("/ai")
public class AIController {

    @PostMapping("/ask")
    public String askAI(@RequestBody String question) {
        try {
            // 调用 Main 类中的 callWithMessage 方法，并传入问题
            GenerationResult result = Main.callWithMessage(question);
            return result.getOutput().getChoices().get(0).getMessage().getContent();
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}