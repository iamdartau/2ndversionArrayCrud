<%@ page import="java.util.ArrayList" %>
<%@ page import="lesson.models.Human" %><%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 12.01.2020
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //взяли, положенный в request, через setAttribute, объект human
    Human human = (Human) request.getAttribute("human");

%>
<!--Вывели на экран как выражение-->
<%="ID: " + human.getId() + " NAME: " + human.getName() + " AGE: " + human.getAge()%>
<!--для сервлета UpdateHumanServlet заготовили форму и из неё принемаем параметры аргументов
 которые нужно обработаь changeHuman -->
<form action="/update" method="get">
    <input type="hidden" name="id" value="<%=human.getId()%>">
    <input type="text" name="name" value="<%=human.getName()%>" placeholder="name">
    <input type="number" name="age" value="<%=human.getAge()%>" placeholder="age">
    <button>submit</button>
</form>
<!--просто кнопка перехожа на начальную страницу-->
<a href="/" role="button">home</a>
</body>
</html>
