package studentHelper.controller;

import studentHelper.daoImpl.StudyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Evgeny on 4/10/17.
 */
public class StudiesListController extends HttpServlet {
    private StudyDaoImpl studyDao = new StudyDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studiesList", studyDao.getAllStudies());
        request.getRequestDispatcher("WEB-INF/pages/listOfStudies.jsp").forward(request, response);
    }
}
