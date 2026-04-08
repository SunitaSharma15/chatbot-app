from fastapi import FastAPI, UploadFile
import requests
import rag   #  FIXED

app = FastAPI()

OLLAMA_URL = "http://localhost:11434/api/generate"


@app.post("/upload")
async def upload(file: UploadFile):
    file_path = f"temp_{file.filename}"

    with open(file_path, "wb") as f:
        f.write(await file.read())

    rag.load_pdf(file_path)   # FIXED

    return {"message": "PDF processed successfully"}


@app.post("/chat")
def chat(request: dict):

    query = request.get("prompt")

    if not query:
        return {"response": "Query is required"}

    #  FIXED
    if rag.index is None:
        return {"response": "Please upload a PDF first."}

    try:
        context_chunks = rag.search(query)   #  FIXED
        context = "\n".join(context_chunks)

        final_prompt = f"""
You are a helpful assistant.

Context:
{context}

Question:
{query}

Answer:
"""

        response = requests.post(
            OLLAMA_URL,
            json={
                "model": "llama3",
                "prompt": final_prompt,
                "stream": False
            }
        )

        data = response.json()

        return {"response": data.get("response")}

    except Exception as e:
        return {"response": f"Error: {str(e)}"}