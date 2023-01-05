<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<jsp:directive.include file = "base.jsp" />
    <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Success - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet" type="text/css" href="resources/css/listCrypto.css">
</head>
   <body>
       
    <section class="product-list ">
      <div>
        <h1 class="title">
          Cryptocoins
          <div class="bottoms">
          <a href="/SOBASE/ListCryptoMain.do?order=desc"><button  type="button">Desc</button> </a>
          <a href="/SOBASE/ListCryptoMain.do?order=asc"><button  type="button">Asc</button> </a>
          </h1>
        </div>
      </div>
      <div class="product-container">
                        <c:forEach var="listValue" items="${cryptoList}">   
                            <div class="card">
                                <div class="title">${listValue.name}</div>
                                    <a href="/SOBASE/cryptoview.do?id=${listValue.id}"> <img src="<c:url value="/resources/img/${listValue.name}.png"/>" style=" width: 64px; height: 64px;"></a>
                                <div class="text">${listValue.description}</div>
                                <div class="info"> <p>Actual price: ${listValue.value} eur.</p> <p>Date: ${listValue.date}</p></div>
                            </div>
                        </c:forEach>           
        </div>
    </section>
    </body>
</html>
