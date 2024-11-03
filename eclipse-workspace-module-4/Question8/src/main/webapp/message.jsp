<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Message </title>
</head>
<body>
    <h2>Send a Message</h2>
    <form action="message" method="post">
        <label for="from">From:</label>
        <input type="email" name="from" required><br><br>

        <label for="to">To:</label>
        <input type="email" name="to" required><br><br>

        <label for="msg">Message:</label>
        <textarea name="msg" required></textarea><br><br>

        <button type="submit">Send Message</button>
    </form>

    <p style="color:green"><%= request.getAttribute("success") != null ? request.getAttribute("success") : "" %></p>
    <p style="color:red"><%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %></p>
</body>
</html>

</body>
</html>