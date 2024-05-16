### GitHub Repository README for Basic RAG Model AI Chatbot

---

# Basic RAG Model AI Chatbot

This project implements a Basic Retrieval-Augmented Generation (RAG) AI chatbot using open-source models and technologies. It consists of a backend implemented in Java with Spring Boot and a frontend built with React. The database used is MySQL for storing vector embeddings, and the embeddings are generated using a pre-trained open-source embedding model.

## Features

- **File or Text Upload**: Users can upload a document or enter text which is then converted into chunks, embeddings are created and stored in a vector database.
- **Chat Interface**: A basic chat interface where users can send messages and receive responses generated through prompt engineering from a language model.

## Technologies Used

- **Backend**: Java, Spring Boot
- **Frontend**: React, HTML, CSS
- **Database**: MySQL
- **Vector Database**: Zilliz/Supabase or any other preferred vector database
- **Embedding Model**: Open-source embedding models (e.g., Sentence Transformers)

## Project Structure

```
.
├── backend
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── velamdir
│   │   │   │           └── backend
│   │   │   │               ├── entity
│   │   │   │               │   └── ImageData.java
│   │   │   │               ├── repository
│   │   │   │               │   └── StorageRepository.java
│   │   │   │               ├── service
│   │   │   │               │   └── StorageService.java
│   │   │   │               ├── util
│   │   │   │               │   └── ImageUtils.java
│   │   │   │               └── controller
│   │   │   │                   └── FileController.java
│   │   │   └── resources
│   │   │       └── application.properties
│   └── pom.xml
├── frontend
│   |
|   |__ public
|      |
|      |__ index.html
|      |__ script.js 
|      |__ styles.css
└── README.md
```

## Getting Started

### Prerequisites

- Java 17
- Node.js
- MySQL
- Maven

### Backend Setup

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/basic-rag-chatbot.git
    cd basic-rag-chatbot/backend
    ```

2. **Configure MySQL**:
    Update `src/main/resources/application.properties` with your MySQL database configurations.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

3. **Build and Run the backend**:
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend Setup

1. **Navigate to the frontend directory**:
    ```sh
    cd ../frontend
    ```

2. **Install dependencies**:
    ```sh
    npm install
    ```

3. **Run the frontend**:
    ```sh
    npm start
    ```

### Using the Application

1. **Upload Documents**: Navigate to the upload page at `http://localhost:3000/upload` and upload your documents or enter text for training the RAG model.
2. **Chat Interface**: Navigate to the chat page at `http://localhost:3000/chat` to start interacting with the AI chatbot.

## API Endpoints

- **Upload API**: `POST /api/upload`
    - Accepts a file or text, processes it into chunks, and stores embeddings in the vector database.
- **Chat API**: `POST /api/chat`
    - Accepts a user query, performs prompt engineering, and returns a generated response.

## Additional Information

- **Vector Database**: You can configure and use Zilliz, Supabase, or any other preferred vector database by updating the relevant parts of the code.
- **Embedding Model**: The project uses an open-source embedding model. You can replace it with any other model as needed.

## Contributing

Feel free to submit issues or pull requests. Contributions are welcome!

## License

This project is licensed under the MIT License.

---

### Additional Comments in Code

To ensure code readability, comments are added in the respective files explaining the key sections and logic implemented.

---

Feel free to reach out for any questions or clarifications. Enjoy building with the Basic RAG Model AI Chatbot!

---

By following the instructions above, you should be able to set up and run the Basic RAG Model AI Chatbot project on your local machine. Make sure to update any configurations as per your setup and requirements.
