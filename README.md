#  AI Chatbot Application

A full-stack AI chatbot built using:

- Spring Boot (Backend)
- FastAPI (AI Service)
- Ollama (Local LLM)
- Angular (Frontend - upcoming)
- RAG (Upcoming)

---

## Features

- Chat with AI (local model, no API cost)
- Context-aware chatbot (remembers conversation)
- Session-based chat (multi-user support)
- Microservice-based AI architecture
- Clean layered design (Controller → Service → AI)
- Production-style project structure

---

##  AI Architecture

Angular (upcoming)
        ↓
Spring Boot (API Gateway)
        ↓
FastAPI (AI Service)
        ↓
Ollama (LLM)

---

##  Project Structure

chatbot-app/
│
├── backend/        # Spring Boot API
├── ai-service/     # FastAPI AI service
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

3. Run FastAPI (AI Service)
cd ai-service
uvicorn main:app --reload
4. Run Backend
cd backend
mvn spring-boot:run
5. Test API

POST:
http://localhost:8080/api/chat

Body:

{
  "message": "Hello",
  "sessionId": "user1"
}

### Current Status

 Phase 1: Chatbot with Ollama
 Phase 2: Chat Memory + Session Support
 Phase 3: FastAPI Integration
 Phase 4: RAG System

### Upcoming Features
Chat with PDF (RAG)
Vector Database integration
Authentication (JWT)
Streaming responses (real-time chat)


##  RAG (Retrieval-Augmented Generation)

- Upload PDF documents
- Convert text into embeddings
- Store in FAISS vector database
- Retrieve relevant chunks
- Generate answers using LLM

---

### Flow

User → Query → Embedding → Vector Search → Context → LLM → Answer

Update Status

## Phase 4: RAG System (PDF Chat)

Final Repo Structure
chatbot-app/
├── backend/
├── ai-service/
│   ├── main.py
│   ├── rag.py   
├── docs/
├── README.md



### Author

Sunita Sharma