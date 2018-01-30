<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
	<h2>${pageTitle}</h2>
	<sf:form action="addSupplier" method="post" modelAttribute="Supplier">
		<%-- <sf:label path="sid">Supplier ID:</sf:label>
		<sf:input type="text" id="sid" path="sid" name="sid" />
		 --%>
		<sf:label path="supplierName">Supplier Name:</sf:label>
		<sf:input text="text" id="supplierName" path="supplierName" />
		
		<sf:button id="register" type="submit" >Register</sf:button>
	</sf:form>
</body>
</html>
