<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="sendMessageForm">
  <input type="email" id="toEmail" name="toEmail" placeholder="Recipient Email" required>
  <textarea id="message" name="message" placeholder="Message"></textarea>
  <button type="submit">Send Message</button>
</form>

<script>
  $("#sendMessageForm").submit(function(event) {
    event.preventDefault();
    $.ajax({
      url: "sendMessage",
      type: "POST",
      data: $(this).serialize(),
      success: function(response) {
        alert(response.message);
      },
      error: function() {
        alert("Error sending message.");
      }
    });
  });
</script>

</body>
</html>