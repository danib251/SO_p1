
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/cryptobuy.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Harvest vase</title>
        <link href="https://fonts.googleapis.com/css?family=Bentham|Playfair+Display|Raleway:400,500|Suranna|Trocchi" rel="stylesheet">
    </head>
    
<body>
  <div class="wrapper">
    <div class="product-info">
      <div class="product-text">
        <h1>${crypto.name}</h1>
        <h2>by crypto.es</h2>
        <p>${crypto.description}</p>
      </div>
      <div class="product-price-btn">
        <p><span>${crypto.value}</span>$</p>
        <button type="button">buy now</button>
      </div>
    </div>
        <div class="img">
            <img src="<c:url value="resources/img/Bitcoin.png"/>"height="372" width="327"/>
        </div>
  </div>

</body>

</html>

