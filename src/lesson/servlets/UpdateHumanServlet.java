package lesson.servlets;

import lesson.dao.DBmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//если что глянь комменты в HomeServlet
@WebServlet(name = "UpdateHumanServlet", value = "/update")
public class UpdateHumanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*У метода changeHuman три аргумента которые он должен принять,
        * так давайте их создадим
        * */
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        //дадим аргументы методу и исполним его
        DBmanager.changeHuman(id, name, age);
        //вернёмся на главную страницу
        request.getRequestDispatcher("/").forward(request,response);
    }

}
