<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Models.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product Page</title>
    <style>
        body {
            font-family: Arial, sans-serif; 
            margin: 30px;
        }
        h1 {
            text-align: center;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-top: 15px;
        }
        input[type=text],
        input[type=number],
        textarea,
        input[type=file] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
        }
        .btn {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<h1>Update Product</h1>
<%	Product product = (Product) session.getAttribute("product");

%>
<form action="ProductController" method="get">
    <input type="hidden" name="edit" value=update>

	<label>Product Id:
        <input type="number" name="id" placeholder="<%= product.getProductId()%>">
    </label>

    <label>Product Name:
        <input type="text" name="productname" placeholder="<%= product.getProductname()%>">
    </label>

    <label>Category:
        <input type="text" name="productCategory" placeholder="<%= product.getProductCategory()%>">
    </label>

    <label>Description:
        <textarea name="producteDscription" rows="4" placeholder="<%= product.getProducteDscription()%>"></textarea>
    </label>

    <label>Price (₹):
        <input type="number" step="0.01" name="productPrice" placeholder="<%= product.getProductPrice()%>">
    </label>

    <label>Stock:
        <input type="number" name="productStock" placeholder="<%= product.getProductStock()%>">
    </label>

    <label>Image:
        <input type="file" name="image" accept="image/*">
    </label>

    <button type="submit" class="btn" >Update Product</button>
</form>

</body>
</html>
