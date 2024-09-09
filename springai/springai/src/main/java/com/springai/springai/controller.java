package com.springai.springai;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class controller {
    private final ChatClient chatClient;
    public controller(ChatClient.Builder builder) {
      this.chatClient = builder.build();
    }
    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
     String response = chatClient.prompt().user(message).call().content();
     return Map.of("generation", response);
  }
    


}
