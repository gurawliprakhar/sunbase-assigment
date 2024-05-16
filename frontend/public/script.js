document.getElementById('sendMessageButton').addEventListener('click', sendMessage);
document.getElementById('uploadButton').addEventListener('click', uploadFile);
document.getElementById('submitTextButton').addEventListener('click', submitText);

function sendMessage() {
    const messageInput = document.getElementById('user-input');
    const message = messageInput.value.trim();
    if (message !== '') {
        fetch('http://localhost:8080/api/chat/send-message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ message: message })
        })
        .then(response => response.text())
        .then(data => {
            const messages = document.getElementById('chat-messages');
            const li = document.createElement('li');
            li.textContent = "You: " + message;
            messages.appendChild(li);
            const liResponse = document.createElement('li');
            liResponse.textContent = "Response: " + data;
            messages.appendChild(liResponse);
            messageInput.value = '';
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
}

function uploadFile() {
    const fileInput = document.getElementById('document-upload');
    const file = fileInput.files[0];
    if (file) {
        const formData = new FormData();
        formData.append('document', file);

        fetch('http://localhost:9191/image/upload-document', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            console.log('File uploaded successfully:', data.message);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    } else {
        console.log('No file selected.');
    }
}

function submitText() {
    const textInput = document.getElementById('text-input').value.trim();
    if (textInput !== '') {
        fetch('http://localhost:8080/api/chat/send-message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ message: textInput })
        })
        .then(response => response.text())
        .then(data => {
            console.log('Text submitted successfully:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    } else {
        console.log('Text input is empty.');
    }
}
