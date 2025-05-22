<%-- 
    Document   : ListUser.jsp
    Created on : Feb 20, 2025, 4:15:49 PM
    Author     : linhd
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
        <form>
            <table>
                <tr>
                    <td>Account: </td>
                    <td><input type="text" name="account" value="${s.getAccount()}" /></td>
                    <td>Password: </td>
                    <td>
                        <input type="text" name="password" value="${s.getPassword()}" />
                        <input type="submit" name="search" value="SEARCH">
                    </td>
                </tr>
                
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="${s.getName()}" /></td>
                    <td>Gender: </td>
                    <td><input type="text" name="gender" value="${s.getGender()}" /></td>
                </tr>
                
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" value="${s.getAddress()}" /></td>
                    <td>Date Of Birth:</td>
                    <td><input type="text" name="dateOfBirth" value="${s.getDateOfBirth()}" /></td>
                </tr>
                
                <tr>
                    <td></td>
                    <td><input type="submit" name="add "value="ADD" /></td>
                    <td><input type="submit" name="update" value="UPDATE" /></td>
                    <td><input type="submit" name="delete" value="DELETE" /></td>
                    <td></td>
                </tr>
            </table>
        </form>
        List Users:
        <table border="1">
            <tr>
                <td>Account</td>
                <td>Password</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>Date Of Birth</td>
            </tr>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td><a href="user?account=${item.getAccount()}&mode=1">${item.getAccount()}</a></td>
                    <td>${item.getPassword()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getAddress()}</td>
                    <td>${item.getDateOfBirth()}</td>
                    <td><a href="user?account=${item.getAccount()}&&mode=2">DELETE</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
