<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Success - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
   <body>
       
       <table class="table">
            <thead>
                <tr>
                  <th scope="col">Name</th>
                  <th scope="col">Description</th>
                  <th scope="col">Pirce</th>
                  <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach var="listValue" items="${cryptoList}">   
                        <tr>
                            <th>${listValue.name}</th>
                            <th>${listValue.description}</th>
                            <th>${listValue.date}</th>
                            <th>${listValue.value}</th>
                            <th><img src="<c:url value="/resources/img/Bitcoin.png"/>" style="padding-left:5px; padding-right: 5px; width: 32px; height: 32px;"></th>
                        </tr>
                    </c:forEach> 
            </tbody>
        </table>
</body>
</html>
</html>