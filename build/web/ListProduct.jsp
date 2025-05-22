<%-- 
    Document   : ListProduct
    Created on : Feb 24, 2025, 2:37:02 PM
    Author     : linhd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <form action="product" method="post">
        <table>
            <tr>
                <td>ProductCode:</td>
                <td><input type="text" name="code" value="${p.getCode()}" /></td>
                <td>ProductName:</td>
                <td>
                    <input type="text" name="name" value="${p.getName()}" />
                    <input type="submit" name="search" value="SEARCH">
                </td>
            </tr>

            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="${p.getPrice()}" /></td>
                <td>Stock:</td>
                <td><input type="text" name="stock" value="${p.getStock()}" /></td>
            </tr>

            <tr>
                <td>Image:</td>
                <td><input type="text" name="image" value="${p.getImage()}" /></td>
                <td>Category:</td>
                <td>
                    <select name="category">
                        <option value="0">All Category:</option>
                        <c:forEach items="${data1}" var="c">
                            <option value="${c.getCode()}"
                                    <c:if test="${p.getCategory()==c.getCode()}">
                                        selected
                                    </c:if>
                                    >${c.getName()}</option>
                        </c:forEach>
                    </select>
                </td>

            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="add" value="ADD"></td>
                <td><input type="submit" name="update" value="UPDATE"></td>
                <td><input type="submit" name="delete" value="DELETE"></td>
                <td></td>
            </tr>

        </table>
    </form>
    List Products:
    <table border="1">
        <tr>
            <td>Product code</td>
            <td>Product name</td>
            <td>Price</td>
            <td>Stock</td>
            <td>Image</td>
            <td>Category</td>
        </tr>
        <c:forEach items="${data}" var="item">
            <tr>
                <td><a href="product?code=${item.getCode()}&mode=1">${item.getCode()}</a></td>
                <td>${item.getName()}</td>
                <td>${item.getPrice()}</td>
                <td>${item.getStock()}</td>
                <td><img height="60" width="80" src="${item.getImage()}"></td>
                <td>${item.getCategory()}</td>
                <td><a href="product?code=${item.getCode()}&mode=2">DELETE</a></td>
            </tr>

        </c:forEach>

    </table>
</body>
</html>
