<%-- 
    Document   : Example
    Created on : Feb 6, 2025, 3:50:34 PM
    Author     : TomTit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="frm" action='demo2' method='get'>
            Enter a:<input type='text' name='a' value="${a}"><br>
            Enter b:<input type='text' name='b' value="${b}"><br>
            Operator:
            <select name="op" onchange="document.getElementById('frm').submit()">
                <c:choose>
                    <c:when test="${op eq '2'}">
                        <option value="0" >All</option>
                        <option value="1">UCLN</option>
                        <option value="2" selected>BCNN</option>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${op eq '1'}">
                                <option value="0">All</option>
                                <option value="1" selected>UCLN</option>
                                <option value="2">BCNN</option>
                            </c:when>
                            <c:otherwise>
                                <option value="0" selected>All</option>
                                <option value="1">UCLN</option>
                                <option value="2" >BCNN</option>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </select><br>
            <input type='submit' name='cong' value='a+b'>
            <input type='submit' name='tru' value='a-b'>
            <input type='submit' name='nhan' value='a*b'>
            <input type='submit' name='chia' value='a/b'><br>
            Result:<input type='text' value="${result}" readonly><br>
            ${err}
            
            <table border ="1">
                <tr>
                    <td>a</td>
                    <td>b</td>
                    <td>Operator</td>
                    <td>Result</td>
                </tr>
                <c:forEach items="${data}" var="item">
                    <tr>
                    <td>${item.getA()}</td>
                    <td>${item.getB()}</td>
                    <td>${item.getOp()}</td>
                    <td>${item.getResult()}</td>
                </tr>
                    
                </c:forEach>
            </table>
        </form>
    </body>
</html>
