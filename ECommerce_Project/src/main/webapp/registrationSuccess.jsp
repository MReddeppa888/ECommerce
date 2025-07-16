<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f0f4f8;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #2e7d32;
        margin-bottom: 20px;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #ffffff;
        background-color: #1976d2;
        padding: 10px 20px;
        border-radius: 6px;
        transition: background-color 0.3s ease;
    }
    a:hover {
        background-color: #1565c0;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Registration Successful!</h1>
        <a href="login.jsp">Go to Login</a>
    </div>
</body>
</html>
