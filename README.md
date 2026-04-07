# AI Chatbot Application

A full-stack AI chatbot built using:

- Spring Boot (Backend)
- Angular (Frontend - upcoming)
- Ollama (Local LLM)
- FastAPI (Planned)
- RAG (Upcoming)

---

## Features

- Chat with AI (local model, no API cost)
- Clean architecture (Controller → Service → AI)
- Scalable for future AI features
- Production-style project structure

---

## Architecture

Angular → Spring Boot → Ollama

---

## Project Structure

chatbot-app/
│
├── backend/        # Spring Boot API
├── frontend/       # Angular UI (coming soon)
├── docs/           # Documentation
└── README.md

---

## Setup Instructions

### 1. Install Ollama
https://ollama.com

### 2. Run Model
```bash
ollama run llama3