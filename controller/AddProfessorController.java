package studentHelper.controller;

import studentHelper.daoImpl.ProfessorDaoImpl;
import studentHelper.model.Professor;
import studentHelper.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/17/17.
 */
@WebServlet(name = "AddProfessorController")
public class AddProfessorController extends HttpServlet {
    private ProfessorDaoImpl professorDao = new ProfessorDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Professor professor = new Professor();
        professor.setFirst_name(request.getParameter("firstName"));
        professor.setSecond_name(request.getParameter("secondName"));
        professor.setFather_name(request.getParameter("fatherName"));
        professor.setBirth_date(request.getParameter("birthDate"));
        professor.setAvg_mark(Double.parseDouble(request.getParameter("avgMark")));

        professorDao.addProffesor(professor);

        request.setAttribute("professorsList", professorDao.getAllProfessors());
        request.getRequestDispatcher("WEB-INF/pages/listOfProfessors.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/addProfessorForm.jsp").forward(request, response);
    }
}
