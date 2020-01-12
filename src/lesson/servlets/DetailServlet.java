package lesson.servlets;

import lesson.dao.DBmanager;
import lesson.models.Human;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
//глянь HomeServlet, если здесь вначале не понятно
@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //наша переменная, для аргумента из метода getHumanById
        int id = Integer.parseInt(request.getParameter("id"));
        //а вот и метод. Как отработает выдаст нам human'а
        Human human = DBmanager.getHumanById(id);
        // проверим, если он существует, то
        if(human!=null){
            //добавим наш объект, будем его на detail.jsp выводить
            request.setAttribute("human", human);
            //перекинь нас на страницу ... ты её сам видишь
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }else {
            //ну а если нет, то запрос не верный, кидай на другую
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}
