<%@ page import="lesson.models.Human" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 10.01.2020
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    /*примем список от request, мы передаём из нашего HomeServlet через setAttribute*/
    ArrayList<Human> allhumans = (ArrayList<Human>) request.getAttribute("humans");
    //условие => если список существует, то
    if (allhumans != null) {
      //-> пройдёмся по нему циклом
        for (Human human : allhumans) {
          //и вытащим у каждого human'а поля name и age
%>
<h1>name:<%=human.getName()%>
</h1>
<p>age: <%=human.getAge()%>
</p>
<!--Здесь у нас ссылка под каждым именем,
которая подставит в нашу адресную строку ссылку на сервлет detail
и передаст туда же id human'а, который мы у каждого циклом вытаскиваем,
то есть ссылка юудет у каждого объета из списка и индивидуальным Id, для каждого своя ссылка-->
<a style="margin: 10px" href="/detail?id=<%=human.getId()%>">detail</a>
<!--Так же для каждого своя фома с кнопкой для удаления,
здесь уже id передаём в value-->
<form style="margin: 10px" action="remove" method="get">
    <input type="hidden" name="id" value="<%=human.getId()%>">
    <button>delete</button>
</form>
<%
        }
    }
%>
<!--Цикл закрылся и теперь одна общая форма на страницу,
куда мы будем вписывать age и name через <input>,
наш сервлет addHuman знает что делать с этими полями-->
<form action="/addHuman" method="get">
    <input type="number" name="age" value="age">
    <input type="text" name="name" value="name">
    <button>add</button>
</form>

</body>
</html>
