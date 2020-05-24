<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>deleteUser</title>
    <style type="text/css">
        .cellbut1 {
            width: 75px;
            height: min-content;
            background: firebrick; /* Красный цвет фона для удаления*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }

        .cellbut2 {
            width: 75px;
            height: min-content;
            background: darkgrey; /* Серый цвет фона для изменения*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }
        .cellbut3 {
            width: 75px;
            height: min-content;
            background: darkgrey; /* Серый цвет фона для изменения*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }


    </style>
</head>
<body>
<div align="center">
    <h2>Delete user</h2>
    <c:forEach var="list" items="${listUsers}">

    ID<br>
    <input size="30" disabled placeholder="<c:out value='${list.id}'/> "> <br>
    NAME<br>
    <input size="30" disabled placeholder="<c:out value='${list.name}'/>"> <br>

    Password<br>
    <input size="30" disabled placeholder="<c:out value='${list.password}'/>"> <br>

    Role<br>
<div class="select"  style="width:225px;" align="center">
    <select disabled size="2" style="width: 225px; " >
        <c:forEach var="list1" items="${ list.userRoles}">
            <option disabled><c:out value='${list1.role}'/></option>
        </c:forEach>
    </select>
</div>

    <br>


    <table>

        <form method="get" action="/admin/adminPageInfo">
            <input class="cellbut2" type="submit" value="Close"/>
        </form>
        <form method="post" action="/admin/delUser">
            <input class="cellbut1" type="submit" value="Delete">
            <input type="hidden" name="id" value="<c:out value='${list.id}'/>">
        </form>
        <form action="/logout" method="post">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input class="cellbut3" type="submit" value="Logout">
        </form>
        </c:forEach>
    </table>


</div>

</body>
</html>
