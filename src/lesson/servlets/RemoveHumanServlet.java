package lesson.servlets;

import lesson.dao.DBmanager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// если что, глянь HomeServlet
@WebServlet(name = "RemoveHumanServlet", value = "/remove")
public class RemoveHumanServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //наш метод имеет аргумент, создадим его
        int id = Integer.parseInt(request.getParameter("id"));
        //а вот и сам метод
        DBmanager.deleteHuman(id);
        //метод завершится и нас перекинет на главную
        request.getRequestDispatcher("/").forward(request,response);
    }
}
