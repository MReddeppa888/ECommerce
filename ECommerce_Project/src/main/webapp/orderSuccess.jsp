<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e3f2fd;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    h1 {
        color: #388e3c;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #fff;
        background-color: #1976d2;
        padding: 10px 20px;
        border-radius: 6px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #1565c0;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Your Order Was Successful!</h1>
        <a href="productsAll.jsp">Continue Shopping</a>
    </div>
</body>
</html>
