# 🤖 AI Chatbot Application

A full-stack AI chatbot built using:

- Spring Boot (Backend)
- Angular (Frontend - upcoming)
- Ollama (Local LLM)
- FastAPI (Planned)
- RAG (Upcoming)

---

## 🚀 Features

- Chat with AI (local model, no API cost)
- Context-aware chatbot (remembers conversation)
- Session-based chat (multi-user support)
- Clean architecture (Controller → Service → AI)
- Production-style project structure

---

## 🏗️ Architecture

Angular → Spring Boot → Ollama

---

## 📦 Project Structure

chatbot-app/
│
├── backend/        # Spring Boot API
├── frontend/       # Angular UI (coming soon)
├── docs/           # Documentation
└── README.md

---

## ⚙️ Setup Instructions

### 1. Install Ollama
https://ollama.com

### 2. Run Model
```bash
ollama run llama3

### 3. Run Backend
cd backend
mvn spring-boot:run

### 4. Test API

POST: http://localhost:8080/api/chat

Body:

{
  "message": "Hello",
  "sessionId": "user1"
}