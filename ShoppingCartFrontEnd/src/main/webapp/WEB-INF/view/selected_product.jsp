<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="cart/add" method="post">
<img alt=""src="${selectedProductImage}"><br>
<input type="text" name="name" value =${selectedproduct.name}>
<input type="text" name="price" value=${selectedproduct.price}>
<input type="text" name="quantity" value=${selectedproduct.description}>

Product Name : ${selectedproduct.name}<br>
Price : ${selectedproduct.price}<br>
Description : ${selectedproduct.description}<br>

<img alt=""src="${selectedProductImage}">

<a href="cart/add?productName=${selectedproduct.name}&price=${selectedproduct.price}&description=${selectedproduct.description}">Add to Cart</a>

</form>
</body>
</html>