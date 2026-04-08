from sentence_transformers import SentenceTransformer
import faiss
import numpy as np
from pypdf import PdfReader

model = SentenceTransformer('all-MiniLM-L6-v2')

documents = []
index = None


def load_pdf(file_path):
    global documents, index

    reader = PdfReader(file_path)
    text = ""

    for page in reader.pages:
        text += page.extract_text()

    # Split into chunks
    chunks = [text[i:i+500] for i in range(0, len(text), 500)]

    documents = chunks

    embeddings = model.encode(chunks)

    dimension = embeddings.shape[1]
    index = faiss.IndexFlatL2(dimension)
    index.add(np.array(embeddings))


def search(query):
    query_embedding = model.encode([query])
    D, I = index.search(np.array(query_embedding), k=3)

    return [documents[i] for i in I[0]]