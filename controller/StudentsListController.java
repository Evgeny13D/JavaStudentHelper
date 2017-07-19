package studentHelper.controller;

import studentHelper.daoImpl.StudentDaoImpl;
import studentHelper.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Evgeny on 4/9/17.
 */
public class StudentsListController extends HttpServlet {
    private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentsList", studentDaoImpl.listStudents());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudent.jsp").forward(request, response);
    }
}
