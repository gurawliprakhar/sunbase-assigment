# Basic RAG Model AI Chatbot

This project is a basic RAG (Retrieval-Augmented Generation) model AI chatbot implemented with a Java backend and a simple HTML/CSS/JS frontend. The backend is built using Spring Boot and interacts with a vector database (e.g., Supabase or Zilliz) to store embeddings. The frontend provides an interface to upload text or files for training the model and a chat interface to interact with the chatbot.

## Features
- Upload text or files to generate embeddings and store them in a vector database.
- Simple chat interface to interact with the chatbot.

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Supabase or Zilliz account (or any vector database of your choice)

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/sunbase-assignment.git
   cd sunbase-assignment
Configure the database connection in src/main/resources/application.properties.

Build and run the Spring Boot application:

bash
Copy code
mvn clean install
mvn spring-boot:run
Open src/main/resources/static/upload.html and src/main/resources/static/chat.html in your browser to use the upload and chat interfaces.

Project Structure
Backend: Java (Spring Boot)

Controllers to handle API requests
Service to process text and file uploads, generate embeddings, and handle chat interactions
Repository to interact with the database
Frontend: HTML/CSS/JS

upload.html for uploading text or files
chat.html for chatting with the AI
API Endpoints
POST /api/uploadText - Upload text for generating embeddings
POST /api/uploadFile - Upload file for generating embeddings
POST /api/chat - Chat with the AI chatbot
License
This project is licensed under the MIT License.

bash
Copy code

### .gitignore

```gitignore
/target
/*.log
/*.tmp
/.idea
/.vscode
/*.iml
/*.class
