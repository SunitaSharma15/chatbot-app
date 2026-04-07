package com.chatbot.dto;

public class ChatRequest {
    private String message;
    
    public ChatRequest() {
		// TODO Auto-generated constructor stub
	}

	public ChatRequest(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}