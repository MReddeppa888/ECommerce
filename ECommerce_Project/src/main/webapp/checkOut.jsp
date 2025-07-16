<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="Models.CartItem" %>
<%@ page import="Models.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .checkout-container {
            max-width: 700px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.15);
        }
        h2 {
            text-align: center;
            margin-bottom: 25px;
        }
        .checkout-item {
            border-bottom: 1px solid #ddd;
            padding: 15px 0;
        }
        .checkout-item:last-child {
            border-bottom: none;
        }
        .checkout-item p {
            margin: 5px 0;
        }
        textarea, select {
            width: 100%;
            padding: 8px;
            margin-top: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }
        .total {
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            margin-top: 20px;
        }
        .place-btn {
            display: block;
            width: 100%;
            padding: 12px;
            background-color: #1a8917;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 18px;
            cursor: pointer;
        }
        .place-btn:hover {
            background-color: #146e12;
        }
    </style>
</head>
<body>
<%
    Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("session_cart");
    double cartTotal = 0;
    CartItem cartItem = null;
%>
<div class="checkout-container">
    <h2>Checkout</h2>
    <form action="placeOrder" method="post">
    <%
        if (cartItems != null && !cartItems.isEmpty()) {
            for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                cartItem = entry.getValue();
                int quantity = cartItem.getProductStock();
                double price = cartItem.getProductPrice();
                double itemTotal = quantity * price;
                cartTotal += itemTotal;
    %>
        <div class="checkout-item">
            <p><strong>Item:</strong> <%= cartItem.getProductname() %></p>
            <p><strong>Price:</strong> ₹ <%= String.format("%.2f", price) %></p>
            <p><strong>Quantity:</strong> <%= quantity %></p>
            <p><strong>Subtotal:</strong> ₹ <%= String.format("%.2f", itemTotal) %></p>
        </div>
    <% } %>

        <input type="hidden" name="cartTotal" value="<%= cartTotal %>">
        <label><strong>Delivery Address:</strong></label>
        <textarea name="address" required></textarea>

        <label><strong>Payment Method:</strong></label>
        <select name="paymentMethod" required>
            <option value="credit">Credit Card</option>
            <option value="debit">Debit Card</option>
            <option value="cash">Cash on Delivery</option>
        </select>

        <div class="total">Total: ₹ <%= String.format("%.2f", cartTotal) %></div>
        <button class="place-btn" type="submit">Place Order</button>
    <% } else { %>
        <p>Your cart is empty.</p>
    <% } %>
    </form>
</div>
</body>
</html>
