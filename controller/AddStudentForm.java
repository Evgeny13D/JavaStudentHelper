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
 * Created by Evgeny on 4/13/17.
 */
@WebServlet(name = "AddStudentForm")
public class AddStudentForm extends HttpServlet {

    private static final StudentDaoImpl studentDaoImpl = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student();

        student.setFirstName(request.getParameter("firstName"));
        student.setSecondName(request.getParameter("secondName"));
        student.setAvgMark(Double.parseDouble(request.getParameter("avgMark")));
        student.setGroupNumber(Integer.parseInt(request.getParameter("groupNumber")));

        studentDaoImpl.addStudent(student);

        request.setAttribute("studentsList", studentDaoImpl.listStudents());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudent.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addStudentForm.jsp").forward(request, response);
    }
}
