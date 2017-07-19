package studentHelper.controller;

import studentHelper.daoImpl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/14/17.
 */
@WebServlet(name = "RemoveServlet")
public class RemoveServlet extends HttpServlet {
    private StudentDaoImpl studentDao = new StudentDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentDao.removeStudent(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("studentsList", studentDao.listStudents());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudent.jsp").forward(request, response);
    }
}
