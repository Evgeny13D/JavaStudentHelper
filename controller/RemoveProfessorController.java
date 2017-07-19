package studentHelper.controller;

import studentHelper.daoImpl.ProfessorDaoImpl;
import studentHelper.model.Professor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/16/17.
 */
@WebServlet(name = "RemoveProfessorController")
public class RemoveProfessorController extends HttpServlet {
    private ProfessorDaoImpl professorDao = new ProfessorDaoImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        professorDao.removeProfessor(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("professorsList", professorDao.getAllProfessors());
        request.getRequestDispatcher("WEB-INF/pages/listOfProfessors.jsp").forward(request, response);
    }
}
