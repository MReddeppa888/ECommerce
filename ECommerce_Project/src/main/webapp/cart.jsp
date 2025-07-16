<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="Models.CartItem" %>
<%@ page import="Models.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .cart-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }
        .cart-card {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 10px;
            width: 320px;
            padding: 15px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }
        .cart-card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
            border-radius: 6px;
        }
        .item-name {
            font-size: 18px;
            font-weight: bold;
            margin: 10px 0 5px;
        }
        .item-details {
            font-size: 14px;
            margin: 6px 0;
        }
        .quantity-form input[type="number"] {
            width: 60px;
            padding: 5px;
            margin-right: 10px;
        }
        .quantity-form button {
            padding: 6px 10px;
            margin: 4px 2px;
            background-color: #1a8917;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .quantity-form button:hover {
            background-color: #146e12;
        }
        .cart-total {
            text-align: center;
            font-size: 20px;
            margin-top: 30px;
            font-weight: bold;
            color: #333;
        }
        .checkout-btn {
            display: block;
            margin: 20px auto;
            padding: 10px 25px;
            background-color: #1a8917;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 18px;
            cursor: pointer;
        }
        .checkout-btn:hover {
            background-color: #146e12;
        }
    </style>
</head>
<body>
<h1>Your Shopping Cart</h1>
<div class="cart-container">
<%
    Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");
    double total = 0;
    if (cartItems != null && !cartItems.isEmpty()) {
        for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
            CartItem cartItem = entry.getValue();
            int itemId = entry.getKey();
            int quantity = cartItem.getProductStock();
            double price = cartItem.getProductPrice();
            double itemTotal = quantity * price;
            total += itemTotal;
%>
    <div class="cart-card">
        <img src="ImageMenuServlet?id=<%= itemId %>&t=<%= System.currentTimeMillis() %>" />
        <div class="item-name"><%= cartItem.getProductname() %></div>
        <div class="item-details">Price: ₹<%= String.format("%.2f", price) %></div>
        <div class="item-details">Quantity: <%= quantity %></div>
        <div class="item-details">Subtotal: ₹<%= String.format("%.2f", itemTotal) %></div>
        <form class="quantity-form" action="cart" method="post">
            <input type="number" name="quantity" value="<%= quantity %>" min="1" />
            <input type="hidden" name="itemId" value="<%= itemId %>" />
            <button type="submit" name="action" value="update">Update</button>
            <button type="submit" name="action" value="remove">Remove</button>
        </form>
    </div>
<%
        }
    } else {
%>
    <p>No items in your cart.</p>
<%
    }
%>
</div>

<% if (total > 0) { %>
    <div class="cart-total">Total: ₹<%= String.format("%.2f", total) %></div>
    <a href="checkOut.jsp"><button class="checkout-btn">Proceed to Checkout</button></a>
<% } %>
</body>
</html>
