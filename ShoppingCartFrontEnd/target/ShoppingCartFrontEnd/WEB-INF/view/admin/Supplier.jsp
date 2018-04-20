<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${SupplierSuccessMessage}
${SupplierErrorMessage }
<form action="supplier/save/" method="post">
<table>
<tr>
<td>ID</td>
<!-- write in the if condition -->
<td><input type="text" name="id"  value="${selectedSupplier.id}"></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value="${selectedSupplier.name}"></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" name="address" value="${selectedSupplier.address}"></td>

<td><input type="submit" value='Submit'></td>
</tr>

</table> 

</form>
<!-- display all the categories -->
<div>
<table border="5"  bgcolor="blue">
<tr>
<td>Supplier Id</td>
<td>Supplier Name</td>
<td>Supplier Address</td>
<td>Action</td>

</tr>

<c:forEach var= "supplier"  items="${suppliers}">
<tr>
<td>${supplier.id}</td>
<td>${supplier.name}</td>
<td>${supplier.address}</td>

<td><a href="supplier/delete/?id=${supplier.id}"> Delete</a></td>
<td><a href="supplier/edit/?id=${supplier.id}"> Edit</a>

</td>
</tr>


${supplier.id}
${supplier.name}
${supplier.address}
</table>
</c:forEach>

</div>

</body>
</html>