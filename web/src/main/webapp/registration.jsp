<%--
  Created by IntelliJ IDEA.
  User: пк
  Date: 15.05.2018
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <input type="text" name="firstName" required placeholder="Имя" value="${requestScope.firstName}"><br>
        <input type="text" name="lastName" required placeholder="Фамилия" value="${requestScope.lastName}"><br>
        <input type="email" name="email" required placeholder="email" value="${requestScope.email}"><br>
        <input type="password" name="password" required placeholder="Пароль"><br>
        <input type="password" name="password2" required placeholder="Повторите пароль"><br>
        <input type="submit" class="button" value="Зарегистрироваться"><br>
    </form>
</div>
</body>
</html>
