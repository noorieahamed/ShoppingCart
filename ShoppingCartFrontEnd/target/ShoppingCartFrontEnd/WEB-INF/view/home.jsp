<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content ="width=device-width,initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Welcome to shopping cart</h2>
		${logoutMessage}
	</center>
	
	
	
	<br>
	<jsp:include page="loginheader.jsp"></jsp:include>
	<!-- <a href="login"> Existing userr</a>
	<a href="register"> New User</a>
	<a href="logout">logout</a>
 -->	<hr color="blue" size="5">
	
<%-- 	<jsp:include page="product_menu.jsp"></jsp:include>--%>	
	<jsp:include page = "new_product_menu.jsp"></jsp:include>
	<c:if  test="${isUserSelectedProduct==true}">
	<jsp:include page="selected_product.jsp"></jsp:include>
	</c:if>
	
	<c:if test="${isAdmin==true}">
	<jsp:include page="admin/adminhome.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedMyCart==true}">
	<jsp:include page="cart.jsp"></jsp:include>
	</c:if>
	${welcomeMessage}
	${errorMessage}
	${successMessage}
	 
	
	
	
	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
</body>
</html>