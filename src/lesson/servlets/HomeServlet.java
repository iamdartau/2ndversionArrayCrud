package lesson.servlets;

import lesson.dao.DBmanager;
import lesson.models.Human;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
// чтобы не указывать в web.xml когда ему этот сервлет использовать, используем аннотацию @ и зададим value
@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends javax.servlet.http.HttpServlet {
    //используем этот метод от родительского класса
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*для работы сервлета на нужеен наш список из класса DBmanager */
        ArrayList<Human> humans = DBmanager.getAllHumans();
        //передадим его его объекту request чтобы потом на index.jsp воспользоваться им
        request.setAttribute("humans", humans);
        //объясним на какую view'шку потом нас прекинуть
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
