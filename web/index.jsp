<%-- 
    Document   : index.jsp
    Created on : Feb 20, 2025, 3:58:28 PM
    Author     : linhd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="user" method="get">
            <table>
                <tr>
                    <td>Account:</td>
                    <td><input type="text" name="account" value="${account}"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text"name="password" value="${password}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="LOGIN">${err}</td>
                    <td></td>
                </tr>
            </table>
        </form>
    </body>
</html>
