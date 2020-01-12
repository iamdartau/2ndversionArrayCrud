package lesson.servlets;

import lesson.dao.DBmanager;
import lesson.models.Human;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//смотри HomeServlet, если тут не понятно на счёт этого класса
@WebServlet(name = "AddHumanServlet", value = "/addHuman")
public class AddHumanServlet extends HttpServlet {
    //метод doPost - для изменений данных на сервере
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*для нашего метода addHuman нужны аргументы,
        так что создадим
        переменную чтобы наш сервлет принял от юзера и обработал */
        int age = Integer.parseInt(request.getParameter("age"));
        // и ещё одну, ведь аргументов несколько
        String name = request.getParameter("name");
        //дадим сервлету объет чтобы он с ним работал
        Human human = new Human(0, age,name);
        //и наш метод в который который добавится наш human
        DBmanager.addHuman(human);
        /*и пусть нас перекинет на главную страницу(index.jsp)
        * мы задали welcome file в web.xml
        * */
        request.getRequestDispatcher("/").forward(request,response);
    }

}
