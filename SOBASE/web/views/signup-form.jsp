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
<link rel="stylesheet" type="text/css" href="resources/css/mainpage.css">
</head>
   <body>
       </section>
    <section class="product-list ">
      <div>
        <h1 class="align-center">
          Cryptocoins
        </h1>
      </div>

      <div class="product-container">
       
           
                        <c:forEach var="listValue" items="${cryptoList}">   
                             
                            <div class="card">
                              <div class="content">
                                <div class="title">${listValue.name}</div>
                                <div class="image">
                                  <a href="/SOBASE/cryptoview.do?id=${listValue.id}"> <img src="<c:url value="/resources/img/${listValue.name}.png"/>" style="padding-bottom: 20px; width: 64px; height: 64px;">
                                </div>
                                <div class="text">
                                  ${listValue.description}
                                </div>
                                <div class="value">
                                  ${listValue.value}
                                </div>
                              </div>
                                

                            </div>
                        </c:forEach>           
            
        </div>
         </div>
      
      
      
    </section>
    </body>
</html>
</html>