<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Models.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        image {
        	 border-radius: 50%; object-fit: cover;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .products {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }
        .product-card {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            width: 300px;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .product-card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
            border-radius: 4px;
        }
        .product-name {
            font-size: 18px;
            font-weight: bold;
            margin: 10px 0 5px;
        }
        .product-category {
            font-size: 14px;
            color: #666;
        }
        .product-description {
            font-size: 14px;
            margin: 10px 0;
        }
        .product-price {
            font-size: 16px;
            font-weight: bold;
            color: #1a8917;
        }
        .stock {
            font-size: 14px;
            color: #555;
        }
        .out-of-stock {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Available Products</h1>
    <div class="products">
        <%
            List<Product> products = (List<Product>) session.getAttribute("product_list");
            if (products != null && !products.isEmpty()) {
                for (Product product : products) {
        %>
        <div class="product-card">
            <img src="ImageServlet?productId=<%= product.getProductId() %>"  height="400"  width="200">          
            <div class="product-name"><%= product.getProductname() %></div>
            <div class="product-category">Category: <%= product.getProductCategory() %></div>
            <div class="product-description"><%= product.getProducteDscription() %></div>
            <div class="product-price">₹<%= product.getProductPrice() %></div>
            <form action="cart" method="post">
                        <input type="hidden" name="action" value="homeCart">
                        <input type="number" value="1" min="1" class="quantity-input" name="quantity">
                        <button class="menu-button" name="itemId" value="<%= product.getProductId() %>">Add to Cart</button>
                    </form>
            <div class="stock">
                <% if (product.getProductStock() > 0) { %>
                    In Stock: <%= product.getProductStock() %>
                <% } else { %>
                    <span class="out-of-stock">Out of Stock</span>
                <% } %>
            </div>
        </div>
        <%
                }
            } else {
        %>
        <p>No products available to display.</p>
        <%
            }
        %>
    </div>
</body>
</html>
