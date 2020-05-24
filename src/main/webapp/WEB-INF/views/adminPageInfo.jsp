<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminPageInfo</title>
    <style type="text/css">

        table {
            border: 1px solid black;
            width: auto;
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

        .cellbut1 {
            width: 100%;
            height: min-content;
            background: firebrick; /* Красный цвет фона для удаления*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }

        .cellbut2 {
            width: 100%;
            height: min-content;
            background: cornflowerblue; /* Синий цвет фона для изменения*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }

        .cellbut3 {
            width: 100%;
            height: min-content;
            background: darkgreen; /* Зеленый цвет фона для добавления */
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }

        .cellbut4 {
            width: 606px;
            height: min-content;
            background: darkgrey; /* Серый цвет фона для изменения*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }
    </style>
</head>
<body>
<div align="center">
<h1 >Admin panel</h1>
<table>

    <caption><h3>Table users</h3></caption>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <th>Role</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>


    <c:forEach var="list" items="${listUsers}">
        <tr>
            <td align="center" width="20"><label><c:out value="${list.id}"/></label></td>
            <form method="post" action="/admin/updateUser">
                <td height="100%" align="center"><label><c:out value="${list.name}"/></label></td>
                <td align="center"><label><c:out value="${list.password}"/></label>
                </td>
                <td>
                    <label>
                        <c:forEach var="list1" items="${ list.userRoles}">
                            <c:out value="${list1.role}"/>
                        </c:forEach>
                    </label>
                </td>
                <td align="center" height="100%">
                    <input type="hidden" name="id" value="<c:out value="${list.id}"/>">
                    <input class="cellbut2" type="submit" value="Update" name="update"><br>
            </form>
            </td>

            <form method="post" action="/admin/deleteUser">
                <td align="center">
                    <input type="hidden" name="id" value="<c:out value="${list.id}"/>">
                    <input class="cellbut1" type="submit" value="Delete" name="delete"><br>
            </form>
            </td>
        </tr>
    </c:forEach>


    <tr>
        <td></td>
        <form method="post" action="/admin/addUser">
            <td><label><input type="text" name="name"></label><br></td>
            <td><label><input type="text" name="password"></label><br></td>
            <td><label></label><br></td>
            </td>

            <td align="center" ; width="20">
                <input class="cellbut3" type="submit" value="Add" name="addUser">
            </td>
            <td>
            </td>
        </form>
    </tr>
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
