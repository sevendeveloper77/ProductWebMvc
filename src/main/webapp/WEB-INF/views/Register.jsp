<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome To Register Page!!</h3>
<form:form action="save" method="POST" modelAttribute="product" enctype="multipart/form-data">
<pre>
<c:if test="${'EDIT' eq Mode}">
ID	  :<form:input path="id" readOnly="true"/>	
</c:if>
CODE  :<form:input path="code"/>
NAME  :<form:input path="name"/>
COST  :<form:input path="cost"/>
GST   :<form:select path="gst">
					<form:option value="">-SELECT-</form:option>
					<form:option value="5">5%-SLAB</form:option>
					<form:option value="12">12%-SLAB</form:option>
					<form:option value="18">18%-SLAB</form:option>
					<form:option value="22">22%-SLAB</form:option>
					<form:option value="27">27%-SLAB</form:option>
		</form:select>
EMAIL :<form:input path="email"/>
DOCU  :<input type="file" name="fileOb" />		
NOTE  :<form:textarea path="note"/>	
<c:choose>
	<c:when test="${'EDIT' eq Mode}">
		<input type="submit" value="UPDATE"/>
	</c:when>
	<c:otherwise>
		<input type="submit" value="SAVE"/>
	</c:otherwise>
</c:choose>

</pre>
</form:form>
${message}
</body>
</html>