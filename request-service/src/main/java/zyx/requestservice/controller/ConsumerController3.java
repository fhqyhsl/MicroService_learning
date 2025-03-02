package zyx.requestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ConsumerController3 {
    private final String SERVICE_URL = "https://www.wanandroid.com/";

    private final WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    @GetMapping("/webClientTest")
    public String webClientTest() {
        Mono<String> mono = webClient
                .get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class);
        mono.subscribe(System.out::println);
        return "请求成功";
    }

    @GetMapping("/clientWan")
    public Mono<String> clientWan(@RequestParam String page) {
        Mono<String> mono = webClient
                .get()
                .uri("article/list/"+page+"/json")
                .retrieve()
                .bodyToMono(String.class);
        return mono;
    }
}
