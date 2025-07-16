<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
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

<h1>Add New Product</h1>

<form action="ProductController" method="post">
    <input type="hidden" name="action" value="save">

    <label>Product Name:
        <input type="text" name="productname" required>
    </label>

    <label>Category:
        <input type="text" name="productCategory" required>
    </label>

    <label>Description:
        <textarea name="producteDscription" rows="4" required></textarea>
    </label>

    <label>Price (₹):
        <input type="number" step="0.01" name="productPrice" required>
    </label>

    <label>Stock:
        <input type="number" name="productStock" required>
    </label>

    <label>Image:
        <input type="file" name="image" accept="image/*">
    </label>

    <button type="submit" class="btn" value="add" name="edit">Add Product</button>
</form>

</body>
</html>
