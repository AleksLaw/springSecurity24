<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userInfoPage</title>
    <style type="text/css">
        table {
            border: 1px solid black;
            width: 610px;
        }
        tr {
            height: 15px;
        }
        th {
            border: 1px solid black
        }
        td {
            align-content: center;
            border: 1px solid black
        }
        .cellbut4 {
            width: 610px;
            margin-bottom: 1px;
            height: min-content;
            background: darkgrey; /* Серый цвет фона для изменения*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }
    </style>
</head>
<body>
<div align="center">
<h2>User information page</h2>
<table>
    <caption>
        About user
    </caption>
    <tr>
        <th>ID</th>
        <th>Email</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach var="list" items="${listUsers}">
        <tr>
            <td align="center" width="20"><c:out value="${list.id}"/></td>
            <td height="100%" align="center"><c:out value="${list.name}"/></td>
            <td align="center"><label><c:out value="${list.password}"/></label></td>
            <td align="center"><label>
                <c:forEach var="list1" items="${ list.userRoles}">
                    <c:out value="${list1.role}"/>
                </c:forEach>
            </label>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/logout" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input class="cellbut4" type="submit" value="Logout">
</form>
</div>
</body>
</html>
