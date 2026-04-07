package com.chatbot.repository;

import com.chatbot.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {

    // Fetch last 10 messages (IMPORTANT)
    List<ChatMessage> findTop10ByOrderByIdDesc();
    
    List<ChatMessage> findTop10BySessionIdOrderByIdDesc(String sessionId);
}