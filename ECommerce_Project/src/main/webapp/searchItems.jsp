<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, Models.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin – searchItems Page</title>
    <style>
    body {
    	font-family: Arial, sans-serif;
    	margin: 20px;
	}
	
	h1 {
	    text-align: center;
	}
	.nav{
		padding-left: 80%;
	}
	
	
	
	table {
	    width: 100%;
	    border-collapse: collapse;
	    margin-top: 20px;
	    border: 5px solid red;
	}
	
	th, td {
	    border: 1px solid #ccc;
	    padding: 8px;
	    text-align: left;
	}
	
	th {
	    background-color: #f2f2f2;
	}
	
	
	
	.actions a {
	    margin-right: 8px;
	    text-decoration: none;
	    color: #0069d9;
	}
	
	.actions a.delete {
	    color: #d9534f;
	}
	
	

    </style>
</head>
<body>
<h1>Search Items </h1>

<!-- LIST SECTION -->
<%
    List<Product> products = (List<Product>) session.getAttribute("search_list"); // or fetch via DAO
    
%>
<form action="find" method="get">

	<div></div>
	<div class="nav">
		<input type="text" name="search">
		<button>search</button>
		<a href="addItem.jsp"><button>add</button></a>
	</div>
</form>
<table>
    
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <%
    	if(products !=null && !(products.isEmpty()==true)){
        for(Product p : products){
        	
    %>
    <tr>
        <td><%= p.getProductId()%></td>
        <td><%= p.getProductname() %></td>
        <td><%= p.getProductCategory() %></td>
        <td>₹<%= p.getProductPrice() %></td>
        <td><%= p.getProductStock() %></td>
        <td><%= p.getProducteDscription() %></td>
        <td class="actions">
        	<form action="">
        		<a href="ProductController?edit=<%= p.getProductId() %>">Edit</a>
            	<a href="ProductController?id=<%= p.getProductId() %>" class="delete" onclick="return confirm('Delete this product?');">Delete</a>
        	</form>
        </td>
    </tr>
    <%
        	}
    	}else {
    %><p>There is no products that names....</p><%} %>
</table>
</body>
</html>
