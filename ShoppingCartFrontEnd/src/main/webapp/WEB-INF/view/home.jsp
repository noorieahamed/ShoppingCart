<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="w3-row">
<div class="w3-half w3-container">
  
  <h1 class="w3-jumbo ">SCARLET DECOR</h1>
  <h1 class="w3-jumbo">Interiors</h1>
</div>
<div class="w3-half w3-container w3-xlarge w3-text-grey">
  
</div>
</div>
	
    <center>
		
		${logoutMessage}
	</center>

	<br>

	<jsp:include page="loginheader.jsp"></jsp:include>

	<!-- <a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
	<a href="register"> <span class="glyphicon glyphicon-user"></span> Register</a>
	
	<a href="logout"> <span class="glyphicon glyphicon-log-out"></span> logout</a>
 -->
	<hr color="blue" size="5">

	<%-- <jsp:include page="product_menu.jsp"></jsp:include> --%>
	<jsp:include page="new_product_menu.jsp"></jsp:include>

	<c:if test="${isUserSelectedProduct==true}">

		<jsp:include page="selected_product.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedMyCart==true}">
		<jsp:include page="cart.jsp"></jsp:include>
	</c:if>

	${welcomeMessage} ${errorMessage} ${successMessage}



	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
	<jsp:include page="template.jsp"></jsp:include>
	
</body>
</html>