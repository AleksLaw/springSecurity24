<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUserPage</title>
    <style type="text/css">
        .cellbut1 {
            width: 229px;
            margin-bottom: 1px;
            height: min-content;
            background: firebrick; /* Красный цвет фона для удаления*/
            color: white; /* Белые буквы */
            font-size: 12pt; /* Размер шрифта в пунктах */
        }



        .cellbut3 {
            width: 229px;
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
    <h2>Add new user</h2>
    <form style="margin: 1px" method="post" action="/admin/addUser">
    NAME<br>
    <input size="30" name="name"> <br>

    Password<br>
    <input size="30" name="password" > <br>

    Role<br>
    <div  class="select"  style="width:225px;" align="center">
        <select name="role" multiple size="2" style="width: 225px; ">

            <option > ADMIN</option>
            <option> USER</option>

        </select>
    </div>

            <input class="cellbut1" type="submit" value="Add">
            <input type="hidden" name="id" value="1">
        </form>
        <form action="/logout" method="post">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input class="cellbut3" type="submit" value="Logout">
        </form>




</div>

</body>
</html>
