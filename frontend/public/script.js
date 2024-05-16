document.getElementById('sendMessage').addEventListener('click', sendMessage);

function sendMessage() {
    const messageInput = document.getElementById('messageInput');
    const message = messageInput.value.trim();
    if (message !== '') {
        const messages = document.getElementById('messages');
        const li = document.createElement('li');
        li.textContent = message;
        messages.appendChild(li);
        messageInput.value = '';
    }
}

document.getElementById('uploadButton').addEventListener('click', uploadFile);

function uploadFile() {
    const fileInput = document.getElementById('fileInput');
    const file = fileInput.files[0];
    if (file) {
        console.log('File selected:', file.name);
        // Code to handle file upload
    } else {
        console.log('No file selected.');
    }
}
