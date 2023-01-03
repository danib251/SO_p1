
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/cryptoInfo.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Harvest vase</title>
        <link href="https://fonts.googleapis.com/css?family=Bentham|Playfair+Display|Raleway:400,500|Suranna|Trocchi" rel="stylesheet">
    </head>
    

<div class="wrapper">
    <div class="product-info">
        <div class="product-text">
            <h1>${crypto.name}</h1>
            <h2>${crypto.value} eur.</h2>
            <p>${crypto.date}</p>
            <p>${crypto.description}</p>
            
            <c:if test="${crypto.purcharse!=null}">
                <h2>Latest transaction</h2>
                <p>Time: ${crypto.purcharse.time}</p>
                <p>Quantity: ${crypto.purcharse.quantity}</p>
                <p>Value: ${crypto.purcharse.value}</p>
            </c:if>
         
            
            
        </div>
     
    </div>
    <div class="image-info">
        <div class="img">
            <img src="<c:url value="resources/img/${crypto.name}.png"/>"height="372" width="327"/>        
        </div>
        <div class="product-price-btn">
            <a href="/SOBASE/buy.do?id=${crypto.id}"><button  type="button">buy now</button> </a>
        </div>
    </div>
                
          
</div>


</html>

