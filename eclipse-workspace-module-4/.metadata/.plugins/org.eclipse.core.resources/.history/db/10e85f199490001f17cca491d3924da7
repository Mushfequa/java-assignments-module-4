<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Messages</h1>
<ul id="messageList"></ul>

<script>
function fetchMessages() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "fetchMessages", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            const messages = JSON.parse(xhr.responseText);
            let messageList = document.getElementById("messageList");
            messageList.innerHTML = ""; 

            if (messages.length > 0) {
                messages.forEach(function(msg) {
                    let listItem = document







</body>
</html>