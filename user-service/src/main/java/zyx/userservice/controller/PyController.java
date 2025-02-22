package zyx.userservice.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class PyController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call-python-service")
    public String callPythonService() {
        // Python 服务的 URL
        String pythonServiceUrl = "http://192.168.1.11:5000/info";

        // 调用 Python 服务
        String response = restTemplate.getForObject(pythonServiceUrl, String.class);

        // 返回 Python 服务的响应
        return "Python 服务返回: " + response;
    }
}