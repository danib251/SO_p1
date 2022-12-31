<%-- 
    Document   : buy
    Created on : 31 dic 2022, 12:07:42
    Author     : danib
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <h1>${crypto.name}</h1>
        <h2>${crypto.value}</h2>
        <div class="inset">
            <p>
              <label for="value">Quantity</label>
              <input type="text" name="value" id="value">
            </p>
        </div>
        <p class="p-container">
            <a href="/SOBASE/makePurchase.do"><button  type="button">buy now</button> </a>
        </p>
    
</html>
