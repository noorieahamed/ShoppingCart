<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="cart"  items="${cartList}">

<input type="text" name="price" value ="${cart.price}"><br>

<img alt=""src="${ImageFolder}${cart,productID}.PNG"><br>
Name: <input type="text" name="name" value ="${cart.product.name}"><br>
Price: <input type="text" name="price" value="${cart.product.price}"><br>
Quantity: <input type="text" name="quantity" value="${cart.quantity}"><br>

Description : ${selectedproduct.description}<br>

</c:forEach>
</body>
</html>