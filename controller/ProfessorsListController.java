package studentHelper.controller;

import studentHelper.daoImpl.ProfessorDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/10/17.
 */
public class ProfessorsListController extends HttpServlet {
    private ProfessorDaoImpl professorDao = new ProfessorDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("professorsList", professorDao.getAllProfessors());
        request.getRequestDispatcher("WEB-INF/pages/listOfProfessors.jsp").forward(request, response);
    }
}
