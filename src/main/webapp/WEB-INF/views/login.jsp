<%@ taglib prefix="width" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .b1 {
        background: cornflowerblue; /* Синий цвет фона */
        color: white; /* Белые буквы */
        font-size: 12pt; /* Размер шрифта в пунктах */
        width: 225px;
    }
</style>
<body>
<div align="center">
    <h2>Please sign in</h2>
    <form method="post" action="/login">
        <input size="30" name="j_username" placeholder="Email address"/> <br>
        <input size="30" name="j_password" placeholder="Password"/> <br>
        <input class="b1" type="submit" value="Sign in"/>
    </form>
    ADMIN ADMIN user for test
</div>
</body>
</html>
