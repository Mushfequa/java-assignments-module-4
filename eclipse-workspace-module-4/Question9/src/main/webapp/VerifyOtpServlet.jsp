<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class VerifyOtpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String enteredOtp = request.getParameter("otp");

        HttpSession session = request.getSession();
        String generatedOtp = (String) session.getAttribute("otp");

        if (enteredOtp.equals(generatedOtp)) {
            session.setAttribute("isLoggedIn", true);
            response.sendRedirect("welcome.jsp");
        } else {
            response.getWriter().println("Invalid OTP, please try again.");
        }
    }
}

</body>
</html>