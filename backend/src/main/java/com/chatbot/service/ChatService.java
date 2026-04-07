package com.chatbot.service;

import com.chatbot.dto.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ChatService {

    private final WebClient webClient = WebClient.create("http://localhost:11434");

    public ChatResponse getResponse(String message) {

        Map<String, Object> request = Map.of(
                "model", "llama3",
                "prompt", message,
                "stream", false
        );

        Map response = webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        String result = (String) response.get("response");

        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setResponse(result);

        return chatResponse;
    }
}