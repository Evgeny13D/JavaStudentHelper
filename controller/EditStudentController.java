package studentHelper.controller;

import studentHelper.daoImpl.StudentDaoImpl;
import studentHelper.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/16/17.
 */
@WebServlet(name = "EditStudentController")
public class EditStudentController extends HttpServlet {
    private StudentDaoImpl studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setSecondName(request.getParameter("secondName"));
        student.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));
        student.setGroupNumber(Integer.parseInt(request.getParameter("groupNumber")));

        int id = Integer.parseInt(request.getParameter("id"));

        studentDao.editStudent(id, student);
        request.setAttribute("studentsList", studentDao.listStudents());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudent.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
