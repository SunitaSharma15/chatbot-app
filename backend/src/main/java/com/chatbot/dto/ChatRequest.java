package com.chatbot.dto;

public class ChatRequest {
    private String message;
    
    private String sessionId;  // NEW 🔥
    
    public ChatRequest() {
		// TODO Auto-generated constructor stub
	}

	
	public ChatRequest(String message, String sessionId) {
		super();
		this.message = message;
		this.sessionId = sessionId;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
    
    
}