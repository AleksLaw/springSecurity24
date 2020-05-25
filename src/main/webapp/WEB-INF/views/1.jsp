<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
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

        .cellbut {
            width: 100%;
            height: min-content;
        }
    </style>
</head>
<body>
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

</table>
<form action="/logout" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input type="submit" value="Logout">
</form>


</body>
</html>
