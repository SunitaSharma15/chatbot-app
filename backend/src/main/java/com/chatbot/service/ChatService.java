package com.chatbot.service;

import com.chatbot.dto.ChatResponse;
import com.chatbot.entity.ChatMessage;
import com.chatbot.repository.ChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public class ChatService {

	private final ChatRepository chatRepository;

	public ChatService(ChatRepository chatRepository) {
		super();
		this.chatRepository = chatRepository;
	}

	private final WebClient webClient = WebClient.create("http://localhost:11434");

	public ChatResponse getResponse(String message) {

		// 1. Fetch last 10 messages
		List<ChatMessage> history = chatRepository.findTop10ByOrderByIdDesc();

		// Reverse to maintain order
		Collections.reverse(history);

		// 2. Build context
		String context = history.stream().map(msg -> msg.getRole() + ": " + msg.getContent())
				.collect(Collectors.joining("\n"));

		// 3. Final prompt
		String finalPrompt = context + "\nUSER: " + message + "\nBOT:";

		// 4. Call Ollama
		Map response = webClient.post().uri("/api/generate")
				.bodyValue(Map.of("model", "llama3", "prompt", finalPrompt, "stream", false)).retrieve()
				.bodyToMono(Map.class).block();

		String botReply = (String) response.get("response");

		// 5. Save USER message
		ChatMessage userMsg = new ChatMessage();
		userMsg.setRole("USER");
		userMsg.setContent(message);
		chatRepository.save(userMsg);

		// 6. Save BOT response
		ChatMessage botMsg = new ChatMessage();
		botMsg.setRole("BOT");
		botMsg.setContent(botReply);
		chatRepository.save(botMsg);

		// 7. Return response
		ChatResponse chatResponse = new ChatResponse();
		chatResponse.setResponse(botReply);

		return chatResponse;
	}
}